package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CarDTO;
import lk.ijse.easycar.entity.Car;
import lk.ijse.easycar.repo.CarRepo;
import lk.ijse.easycar.service.CarService;
import lk.ijse.easycar.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService service;

    @Autowired
    private CarRepo repo;

    @Autowired
    private ModelMapper mapper;

    @PostMapping(path = "/save")
    public ResponseUtil saveCar(CarDTO dto){
        service.saveCar(dto);
        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }

    @PutMapping(path = "/update")
    public ResponseUtil updateCar(@RequestBody CarDTO dto){
        service.updateCar(dto);
        return new ResponseUtil("OK", "Successfully Updated..!", dto);
    }

    @DeleteMapping(path = "/delete")
    public ResponseUtil deleteCar(String cr_reg){
        service.deleteCar(cr_reg);
        return new ResponseUtil("OK", "Successfully Deleted..!", null);
    }

    @GetMapping(path = "/allcar")
    public ResponseUtil getAllCars(){
        ArrayList allList = service.getAllCars();
        return new ResponseUtil("OK", "Successfully loaded..!", allList);
    }

    @GetMapping(path ="/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil countCar(){
        int count = service.countCars();
        return new ResponseUtil("OK", "Successfully Counted!", count);
    }


}
