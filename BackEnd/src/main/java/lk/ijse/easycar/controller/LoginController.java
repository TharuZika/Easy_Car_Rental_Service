package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.AdminDTO;
import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.entity.Admin;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.entity.User;
import lk.ijse.easycar.repo.AdminRepo;
import lk.ijse.easycar.repo.CustomerRepo;
import lk.ijse.easycar.repo.DriverRepo;
import lk.ijse.easycar.repo.UserRepo;
import lk.ijse.easycar.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AdminRepo adminRepo;

    @PostMapping(path = "/user")
    public ResponseUtil loginUser(@RequestBody UserDTO userDto){
        User map = mapper.map(userRepo.findByUserName(userDto.getUserName()), User.class);
        if (!map.getPassword().equals(userDto.getPassword())){
            System.out.println("Password incorrect");
            return new ResponseUtil("Error", "Password or Username Incorrect", null);
        }

        User user = userRepo.findByUserName(userDto.getUserName());
        UserDTO userDTO = mapper.map(user, UserDTO.class);

        return new ResponseUtil("Ok", "Successfully Login", userDTO);


//        if (map.getRole().equals("Customer")){
//            System.out.println("This is Customer");
//            Optional<Customer> customer = customerRepo.findById(map.getUserId());
//            CustomerDTO customerDTO = mapper.map(customer, CustomerDTO.class);
//            System.out.println(customerDTO.getCus_name());
//
//            return new ResponseUtil("Ok", "Successfully Login", customerDTO);
//        }if (map.getRole().equals("Driver")){
//            System.out.println("This is Driver");
//            Optional<Driver> driver = driverRepo.findById(map.getUserId());
//            return new ResponseUtil("Ok", "Successfully Login", driver);
//        }
    }


    @GetMapping(path = "/customer")
    public ResponseUtil loginCustomer(String userId){
        Optional<Customer> customer = customerRepo.findById(userId);
        CustomerDTO customerDTO = mapper.map(customer, CustomerDTO.class);
        System.out.println(customerDTO.getCus_name());

        return new ResponseUtil("Ok", "Successfully Login", customerDTO);
    }

    @GetMapping(path = "/driverinfo")
    public ResponseUtil loginDriverInfo(String userId){
        Optional<Driver> driver = driverRepo.findById(userId);
        DriverDTO driverDTO = mapper.map(driver, DriverDTO.class);
        System.out.println(driverDTO.getDr_name());

        return new ResponseUtil("Ok", "Successfully Login", driverDTO);
    }

    @PostMapping(path = "/driver")
    public ResponseUtil loginDriver(String userId){
        Optional<Driver> driver = driverRepo.findById(userId);
        DriverDTO driverDTO = mapper.map(driver, DriverDTO.class);
        System.out.println(driverDTO.getDr_name());

        return new ResponseUtil("Ok", "Successfully Login", driverDTO);
    }

    @PostMapping(path = "/admin")
    public ResponseUtil loginAdmin(String userId){
        Optional<Admin> admin = adminRepo.findById(userId);
        AdminDTO adminDTO = mapper.map(admin, AdminDTO.class);
        System.out.println(adminDTO.getAdminName());

        return new ResponseUtil("Ok", "Successfully Login", adminDTO);
    }

}
