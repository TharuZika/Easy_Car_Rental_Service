package lk.ijse.easycar.repo;

import lk.ijse.easycar.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepo extends JpaRepository<Booking, String> {
    @Query(value = "SELECT COUNT(*) FROM booking", nativeQuery = true)
    int countBooking();

    @Query(value = "SELECT bk_id FROM booking ORDER BY bk_id DESC LIMIT 1", nativeQuery = true)
    String generateBookingIds();

}
