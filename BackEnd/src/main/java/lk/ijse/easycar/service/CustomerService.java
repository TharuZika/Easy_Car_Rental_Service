package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface CustomerService {

    public void saveCustomer(CustomerDTO dto);

    public void deleteCustomer(String id);

    public void updateCustomer(CustomerDTO dto);

    public ArrayList<CustomerDTO> getAllCustomers();

    public CustomerDTO searchCustomerWithName(String name);

    int countCustomer();
}
