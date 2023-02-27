package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.CarDTO;
import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.entity.Car;
import lk.ijse.easycar.repo.CarRepo;
import lk.ijse.easycar.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if (repo.existsById(dto.getCr_reg())){
            throw new RuntimeException("Car Already Registered");
        }
        Car map =mapper.map(dto, Car.class);
        repo.save(map);

    }

    @Override
    public void deleteCar(String cr_reg) {
        if (!repo.existsById(cr_reg)){
            throw new RuntimeException("Car Not Found");
        }
        repo.deleteById(cr_reg);
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (!repo.existsById(dto.getCr_reg())){
            throw new RuntimeException("Car Not Found");
        }
        Car map =mapper.map(dto, Car.class);
        repo.save(map);
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        List<Car> all = repo.findAll();
        ArrayList<CarDTO> allList = mapper.map(all, new TypeToken<ArrayList<CarDTO>>(){}.getType());
        return allList;
    }

    @Override
    public int countCars() {
        return repo.countCar();
    }

    @Override
    public CarDTO findCar(String cr_reg) {
        Optional<Car> byId = repo.findById(cr_reg);
        return mapper.map(byId, CarDTO.class);
    }

}
