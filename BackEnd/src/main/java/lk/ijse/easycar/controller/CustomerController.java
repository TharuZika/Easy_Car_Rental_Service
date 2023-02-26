package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;

import lk.ijse.easycar.service.CustomerService;
import lk.ijse.easycar.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;


import javax.xml.xpath.XPath;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {



    @Autowired
    private CustomerService service;


    @PostMapping(path = "/save")
    public ResponseUtil saveCustomer(CustomerDTO dto) {
        service.saveCustomer(dto);

//        service.saveCustomer(dto);
//
//        try {
////            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//
//            File uploadsDir = new File("C:\\Users\\ASUS\\Documents\\GDSE60\\Advanced API\\AAD CourseWork\\Easy_car_rental_private_limited" + "/uploads");
//            System.out.println(uploadsDir);
//            uploadsDir.mkdir();
//            dto.getCus_img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getCus_img().getOriginalFilename()));
//
//            Customer cus = new Customer();
//            String fileName = StringUtils.cleanPath(dto.getCus_img().getOriginalFilename());
//            if (fileName.contains("..")) {
//                System.out.println("Can't Process Image");
//                throw new RuntimeException("Can't Process Image!");
//            }
//            cus.setCus_nic(dto.getCus_nic());
//            cus.setCus_name(dto.getCus_name());
//            cus.setCus_address(dto.getCus_address());
//            cus.setCus_contact(dto.getCus_contact());
//            cus.setCus_email(dto.getCus_email());
//            cus.setCus_img("uploads/" + dto.getCus_img().getOriginalFilename());
//
//            repo.save(cus);
//
//            System.out.println(fileName + " : " + dto.getCus_img());
//
//        }catch (IOException e){
//            e.printStackTrace();
//            System.out.println("Error Here 1");
//            throw new RuntimeException("Something went wrong! : "+e);
//        }//catch (URISyntaxException e){
//            System.out.println("Error Here 2");
//            throw new RuntimeException("Something went wrong! : "+e);
//        }

        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }
    @DeleteMapping(path = "/delete")
    public ResponseUtil deleteCustomer(String cus_nic){
        service.deleteCustomer(cus_nic);
        return new ResponseUtil("OK", "Successfully Deleted! : "+cus_nic, null);
    }

    @PutMapping(path = "/update")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
        service.updateCustomer(dto);
        return new ResponseUtil("OK", "Successfully updated! : "+dto.getCus_name(), dto);
    }

    @GetMapping(path = "/allcus")
    public ResponseUtil getAllCustomers(){
       List allList = service.getAllCustomers();
        return new ResponseUtil("OK", "Successfully Loaded!", allList);
    }

    @GetMapping(path ="/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil countCustomers(){
        int count = service.countCustomer();
        return new ResponseUtil("OK", "Successfully Counted!", count);
    }



}