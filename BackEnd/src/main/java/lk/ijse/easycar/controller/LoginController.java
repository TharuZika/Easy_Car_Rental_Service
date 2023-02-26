package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.entity.User;
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

    @PostMapping
    public ResponseUtil loginUser(@RequestBody UserDTO dto){
        User map = mapper.map(userRepo.findById(dto.getUserName()), User.class);
        if (!map.getPassword().equals(dto.getPassword())){
            System.out.println("Password incorrect");
            return new ResponseUtil("Error", "Password or Username Incorrect", null);
        }
        if (map.getRole().equals("Customer")){
            System.out.println("This is Customer");
            CustomerDTO customer = customerRepo.findCustomerByCus_nic(map.getUserId());
            return new ResponseUtil("Ok", "Successfully Login", customer);
        }if (map.getRole().equals("Driver")){
            System.out.println("This is Driver");
            Optional<Driver> driver = driverRepo.findById(map.getUserId());
            return new ResponseUtil("Ok", "Successfully Login", driver);
        }

        return new ResponseUtil("Ok", "Successfully Login", null);
    }

}
