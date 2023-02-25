package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.CarDTO;
import lk.ijse.easycar.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface CarService {

    public void saveCar(CarDTO dto);

    public void deleteCar(String cr_reg);

    public void updateCar(CarDTO dto);

    public ArrayList<CarDTO> getAllCars();


}
