package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.repo.CustomerRepo;
import lk.ijse.easycar.service.CustomerService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute  CustomerDTO dto, @RequestParam(name = "cus_img", required = false) MultipartFile cusImg) {

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();
            cusImg.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getCus_img().getOriginalFilename()));

            Customer cus = new Customer();
            String fileName = StringUtils.cleanPath(cusImg.getOriginalFilename());
            if (fileName.contains("..")){
                System.out.println("Can't Process Image");
            }
            cus.setCus_nic(dto.getCus_nic());
            cus.setCus_name(dto.getCus_name());
            cus.setCus_address(dto.getCus_address());
            cus.setCus_contact(dto.getCus_contact());
            cus.setCus_email(dto.getCus_email());
            cus.setCus_img("uploads/" + cusImg.getOriginalFilename());

            customerRepo.save(cus);

            return new ResponseUtil("OK", "Successfully Registered..!", dto);

        }catch (IOException e){
            return new ResponseUtil("Error", "Something Went Wrong..! "+e, null);
        }catch (URISyntaxException e){
            return new ResponseUtil("Error", "Something Went Wrong..! "+e, null);
        }

    }


}
