package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.AdminDTO;
import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.dto.UserDTO;
import lk.ijse.easycar.entity.User;
import lk.ijse.easycar.repo.CustomerRepo;
import lk.ijse.easycar.repo.DriverRepo;
import lk.ijse.easycar.repo.UserRepo;
import lk.ijse.easycar.service.RegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CustomerRepo driverRepo;

    @Autowired
    private DriverRepo customerRepo;

    @Override
    public void saveCustomer(@RequestBody UserDTO dto) {
        userRepo.save(mapper.map(dto, User.class));
    }

    @Override
    public void saveDriver(String userId, String userName, String password, String role) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setRole(role);
        userRepo.save(user);
    }

    @Override
    public void saveAdmin(String userId, String userName, String password, String role) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setRole(role);
        userRepo.save(user);
    }

    @Override
    public UserDTO findUser(String userId) {
        User byUserId = userRepo.findByUserId(userId);
        UserDTO map = mapper.map(byUserId, UserDTO.class);
        return map;
    }

    @Override
    public void deleteUser(String userId) {
        userRepo.deleteById(userId);
    }
}
