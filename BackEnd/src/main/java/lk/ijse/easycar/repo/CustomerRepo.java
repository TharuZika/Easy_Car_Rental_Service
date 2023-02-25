package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query(value = "SELECT COUNT(*) FROM customer", nativeQuery = true)
    int countCustomer();


}
