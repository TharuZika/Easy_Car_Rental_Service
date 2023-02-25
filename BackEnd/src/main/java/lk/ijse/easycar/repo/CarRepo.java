package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, String> {
}
