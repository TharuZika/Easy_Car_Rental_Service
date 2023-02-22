package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.DriverDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface DriverService {

    public void saveDriver(DriverDTO dto);

    public void deleteDriver(String id);

    public void updateDriver(DriverDTO dto);

    public ArrayList<DriverDTO> getAllDrivers();

    public DriverDTO searchDriverWithName(String name);
}
