package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.CarDTO;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {

    @PostMapping
    public ResponseUtil saveCar(CarDTO dto){
        return new ResponseUtil("OK", "Successfully Registered..!", dto);
    }

}
