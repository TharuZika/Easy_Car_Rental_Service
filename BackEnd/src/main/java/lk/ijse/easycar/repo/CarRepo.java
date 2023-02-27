package lk.ijse.easycar.repo;

import lk.ijse.easycar.dto.CustomerDTO;
import lk.ijse.easycar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, String> {
    @Query(value = "SELECT COUNT(*) FROM car", nativeQuery = true)
    int countCar();

    CustomerDTO findByCr_reg(String cr_reg);
}
