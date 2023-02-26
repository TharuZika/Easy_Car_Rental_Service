package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.AdminDTO;
import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.dto.UserDTO;

public interface RegisterService {
    public void saveCustomer(UserDTO dto);
    public void saveDriver(UserDTO dto);
    public void saveAdmin(UserDTO dto);
}
