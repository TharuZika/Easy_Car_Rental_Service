package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.UserDTO;
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

    @PostMapping(path = "/driver")
    public ResponseUtil saveDriver(UserDTO dto){
        service.saveDriver(dto);
        return new ResponseUtil("OK", "Success", null);
    }

    @PostMapping(path = "/admin")
    public ResponseUtil saveAdmin(UserDTO dto){
        service.saveAdmin(dto);
        return new ResponseUtil("OK", "Success", null);
    }

}
