package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.repo.DriverRepo;
import lk.ijse.easycar.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void saveDriver(DriverDTO dto) {
        if (repo.existsById(dto.getDr_lic())){
            throw new RuntimeException("Driver Already Exists!");
        }
        repo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public void deleteDriver(String dr_lic) {
        if (!repo.existsById(dr_lic)){
            throw new RuntimeException("Driver Not Found!");
        }
        repo.deleteById(dr_lic);
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        System.out.println("Driver : "+dto.getDr_lic());
        if (!repo.existsById(dto.getDr_lic())){
            throw new RuntimeException("Driver Not Found!");
        }
        repo.save(mapper.map(dto, Driver.class));

    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        List<Driver> all = repo.findAll();
        ArrayList<DriverDTO> allList = mapper.map(all, new TypeToken<ArrayList<DriverDTO>>(){}.getType());
        return allList;
    }

    @Override
    public DriverDTO searchDriverWithName(String name) {
        return null;
    }

    @Override
    public int countDriver() {
        return repo.countDriver();
    }


}
