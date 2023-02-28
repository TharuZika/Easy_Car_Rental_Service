package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.BookingDTO;
import lk.ijse.easycar.dto.CarDTO;

import java.util.ArrayList;

public interface BookingService {
    public void saveBooking(BookingDTO dto);

    public void deleteBooking(String bk_id);

    public void updateBooking(BookingDTO dto);

    public ArrayList<BookingDTO> getAllBooking();

    public int countBooking();

    public BookingDTO findBooking(String bk_id);

    public String generateBookingIds();

}
