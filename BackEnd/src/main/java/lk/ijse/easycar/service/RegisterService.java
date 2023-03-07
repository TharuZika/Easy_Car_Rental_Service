package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.AdminDTO;
import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.entity.User;

import java.util.ArrayList;

public interface RegisterService {
    public void saveCustomer(UserDTO dto);
    public void saveDriver(String userId, String userName, String password, String role);
    public void saveAdmin(String userId, String userName, String password, String role);
    public UserDTO findUser(String userId);

    public void updateUser(String userId, String userName, String password, String role);

    public void deleteUser(String userId);

    public ArrayList<UserDTO> getAllUsers();

    public UserDTO findUserByUseId(String userId);
}
