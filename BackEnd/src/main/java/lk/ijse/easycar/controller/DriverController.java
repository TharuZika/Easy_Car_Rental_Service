package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.repo.DriverRepo;
import lk.ijse.easycar.service.DriverService;
import lk.ijse.easycar.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private DriverService service;

    @PostMapping(path = "/save")
    public ResponseUtil saveDriver(DriverDTO dto){
       service.saveDriver(dto);
       return new ResponseUtil("OK", "Successfully Registered..!", null);
    }

    @GetMapping(path = "/alldr")
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil("OK", "Successfully loaded..!", service.getAllDrivers());
    }

    @PutMapping(path = "/update")
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        service.updateDriver(dto);
        return new ResponseUtil("OK", "Successfully Updated..!", dto);
    }

    @GetMapping(path ="/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil countDrivers(){
        int count = service.countDriver();
        return new ResponseUtil("OK", "Successfully Counted!", count);
    }

}
