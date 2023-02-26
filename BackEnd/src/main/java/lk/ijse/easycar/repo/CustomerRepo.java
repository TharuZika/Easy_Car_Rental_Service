package lk.ijse.easycar.repo;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query(value = "SELECT COUNT(*) FROM customer", nativeQuery = true)
    int countCustomer();

    @Query(value = "SELECT * FROM customer where cus_nic= id", nativeQuery = true)
    CustomerDTO findCustomerByCus_nic(String id);


}
