package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, String> {
}
