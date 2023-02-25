package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CarDTO;
import lk.ijse.easycar.entity.Car;
import lk.ijse.easycar.repo.CarRepo;
import lk.ijse.easycar.service.CarService;
import lk.ijse.easycar.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public ResponseUtil saveCar(CarDTO dto){
        service.saveCar(dto);
        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }

    @PutMapping
    public ResponseUtil updateCar(CarDTO dto){
        service.updateCar(dto);
        return new ResponseUtil("OK", "Successfully Updated..!", null);
    }

    @DeleteMapping
    public ResponseUtil deleteCar(String cr_reg){
        service.deleteCar(cr_reg);
        return new ResponseUtil("OK", "Successfully Deleted..!", null);
    }

    @GetMapping
    public ResponseUtil getAllCars(){
        ArrayList allList = service.getAllCars();
        return new ResponseUtil("OK", "Successfully loaded..!", allList);
    }


}
