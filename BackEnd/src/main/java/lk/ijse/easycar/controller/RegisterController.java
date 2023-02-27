package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.entity.User;
import lk.ijse.easycar.service.RegisterService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService service;

    @PostMapping(path = "/customer")
    public ResponseUtil saveCustomer(@RequestBody UserDTO dto){
        service.saveCustomer(dto);
        return new ResponseUtil("OK", "Success", null);
    }

    @PutMapping("/updatecus")
    public ResponseUtil updateCusLogin(@RequestBody UserDTO dto){
        System.out.println("Customer Login Save Method Invoked");
        service.saveCustomer(dto);
        return new ResponseUtil("OK", "Success", null);
    }

    @DeleteMapping(path = "/deletecustomer")
    public ResponseUtil deleteCustomer(String userName){
        System.out.println("User Login Info Delete Method Invoked : "+userName);
        service.deleteUser(userName);
        return new ResponseUtil("OK", "Successfully Deleted : "+userName, null);
    }

    @GetMapping(path = "/getuser")
    public ResponseUtil getUser(String userName){
        User user = service.findUser(userName);
        return new ResponseUtil("OK", "Successfully Found : "+userName, user);
    }

    @PostMapping(path = "/admin")
    public ResponseUtil saveAdmin(UserDTO dto){
        service.saveAdmin(dto);
        return new ResponseUtil("OK", "Success", null);
    }

    @PostMapping(path = "/driver")
    public ResponseUtil saveDriver(String userId, String userName, String password, String role){
        service.saveDriver(userId, userName, password, role);
        return new ResponseUtil("OK", "Success", null);
    }

    @DeleteMapping(path = "/deletedriver")
    public ResponseUtil deleteDriver(String userName){
        service.deleteUser(userName);
        return new ResponseUtil("OK", "Success", null);
    }

}
