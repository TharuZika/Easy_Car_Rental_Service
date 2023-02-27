package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.AdminDTO;
import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.entity.User;

public interface RegisterService {
    public void saveCustomer(UserDTO dto);
    public void saveDriver(String userId, String userName, String password, String role);
    public void saveAdmin(UserDTO dto);
    public User findUser(String userId);

    public void deleteUser(String userId);
}
