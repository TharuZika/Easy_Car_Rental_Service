package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.repo.CustomerRepo;
import lk.ijse.easycar.service.CustomerService;
import lk.ijse.easycar.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Autowired
    private CustomerService service;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(CustomerDTO dto) {
        if(repo.existsById(dto.getCus_nic())){
            throw new RuntimeException("User already exist!");
        }
//        service.saveCustomer(dto);

        try {
//            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();

            File uploadsDir = new File("C:\\Users\\ASUS\\Documents\\GDSE60\\Advanced API\\AAD CourseWork\\Easy_car_rental_private_limited" + "/uploads");
            System.out.println(uploadsDir);
            uploadsDir.mkdir();
            dto.getCus_img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getCus_img().getOriginalFilename()));

            Customer cus = new Customer();
            String fileName = StringUtils.cleanPath(dto.getCus_img().getOriginalFilename());
            if (fileName.contains("..")) {
                System.out.println("Can't Process Image");
                throw new RuntimeException("Can't Process Image!");
            }
            cus.setCus_nic(dto.getCus_nic());
            cus.setCus_name(dto.getCus_name());
            cus.setCus_address(dto.getCus_address());
            cus.setCus_contact(dto.getCus_contact());
            cus.setCus_email(dto.getCus_email());
            cus.setCus_img("uploads/" + dto.getCus_img().getOriginalFilename());

            repo.save(cus);

            System.out.println(fileName + " : " + dto.getCus_img());

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error Here 1");
            throw new RuntimeException("Something went wrong! : "+e);
         }//catch (URISyntaxException e){
//            System.out.println("Error Here 2");
//            throw new RuntimeException("Something went wrong! : "+e);
//        }

        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }
    @DeleteMapping
    public ResponseUtil deleteCustomer(String dr_nic){
        if (!repo.existsById(dr_nic)){
            throw new RuntimeException("User Not Found : "+dr_nic);
        }
        repo.deleteById(dr_nic);
        System.out.println(dr_nic);
        return new ResponseUtil("OK", "Successfully Deleted : "+dr_nic, null);
    }

    @GetMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers(){
        List<Customer> all = repo.findAll();
        ArrayList<CustomerDTO> allList = mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
        return new ResponseUtil("OK", "Successfully Deleted", allList);
    }


}
