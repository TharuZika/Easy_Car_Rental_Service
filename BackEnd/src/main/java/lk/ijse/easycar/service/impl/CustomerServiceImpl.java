package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.repo.CustomerRepo;
import lk.ijse.easycar.service.CustomerService;
import lk.ijse.easycar.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();
            dto.getCus_img().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + dto.getCus_img().getOriginalFilename()));

            Customer cus = new Customer();
            String fileName = StringUtils.cleanPath(dto.getCus_img().getOriginalFilename());
            if (fileName.contains("..")) {
                System.out.println("Can't Process Image");
                throw new RuntimeException("Can't Process Image!");
            }
            cus.setCus_nic(dto.getCus_nic());
            cus.setCus_name(dto.getCus_name());
            cus.setCus_address(dto.getCus_address());
            cus.setCus_contact(dto.getCus_contact());
            cus.setCus_email(dto.getCus_email());
            cus.setCus_img("uploads/" + dto.getCus_img().getOriginalFilename());

            repo.save(cus);

            System.out.println(fileName + " : " + dto.getCus_img());

        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Something went wrong! : "+e);
        }catch (URISyntaxException e){
            throw new RuntimeException("Something went wrong! : "+e);
        }
    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public void updateCustomer(CustomerDTO dto) {

    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public CustomerDTO searchCustomerWithName(String name) {
        return null;
    }
}
