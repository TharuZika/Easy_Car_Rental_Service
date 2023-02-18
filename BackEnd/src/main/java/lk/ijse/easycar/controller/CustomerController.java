package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.repo.CustomerRepo;
import lk.ijse.easycar.service.CustomerService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping
    public ResponseUtil saveCustomer(CustomerDTO dto){
        service.saveCustomer(dto);
        return new ResponseUtil("OK", "Successfully Registered..!", dto);
    }

    @PostMapping("/uploadImage")
    public void uploadImage(@RequestParam("image") MultipartFile image) throws IOException {
        // get the image data from the request
        byte[] imageData = image.getBytes();

        // save the image data to the database
        System.out.println(imageData);
    }


}
