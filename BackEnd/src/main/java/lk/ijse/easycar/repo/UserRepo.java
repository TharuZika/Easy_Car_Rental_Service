package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    boolean existsByUserName(String name);
    User findByUserName(String userName);
}
