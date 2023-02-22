package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.service.DriverService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute  DriverDTO dto){
        service.saveDriver(dto);
        return new ResponseUtil("OK", "Successfully Registered..!", dto);
    }


}
