package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<Driver, String> {
}
