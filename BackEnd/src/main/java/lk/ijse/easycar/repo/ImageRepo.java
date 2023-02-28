package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image, String> {

}
