package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.repo.DriverRepo;
import lk.ijse.easycar.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void saveDriver(DriverDTO dto) {
        Driver map = mapper.map(dto, Driver.class);
        repo.save(map);
    }

    @Override
    public void deleteDriver(String id) {

    }

    @Override
    public void updateDriver(DriverDTO dto) {

    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        return null;
    }

    @Override
    public DriverDTO searchDriverWithName(String name) {
        return null;
    }
}
