package lk.ijse.easycar.repo;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.entity.Customer;
import lk.ijse.easycar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query(value = "SELECT COUNT(*) FROM customer", nativeQuery = true)
    int countCustomer();

    @Query(value = "SELECT * FROM customer c  WHERE c.cus_nic =:userId;", nativeQuery = true)
    Customer findByUserNic(@Param("userId") String userId);


}
