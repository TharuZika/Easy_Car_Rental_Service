package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.entity.User;
import lk.ijse.easycar.repo.CustomerRepo;
import lk.ijse.easycar.repo.UserRepo;
import lk.ijse.easycar.service.CustomerService;
import lk.ijse.easycar.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if(repo.existsById(dto.getCus_nic())){
            throw new RuntimeException("User already exist!");
        }
        repo.save(mapper.map(dto, Customer.class));

    }

    @Override
    public void deleteCustomer(String cus_nic) {
        if (!repo.existsById(cus_nic)){
            throw new RuntimeException("User Not Found : "+cus_nic);
        }
        repo.deleteById(cus_nic);
        System.out.println(cus_nic);
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getCus_nic())){
            throw new RuntimeException("User Not Found : "+dto.getCus_nic());
        }
        repo.save(mapper.map(dto, Customer.class));

    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        ArrayList<CustomerDTO> allList = mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
        return allList;
    }

    @Override
    public CustomerDTO searchCustomerWithName(String name) {
        return null;
    }

    @Override
    public int countCustomer() {
        return repo.countCustomer();
    }

}
