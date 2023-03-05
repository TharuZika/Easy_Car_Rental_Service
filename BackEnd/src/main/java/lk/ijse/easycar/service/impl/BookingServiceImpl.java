package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.BookingDTO;
import lk.ijse.easycar.dto.CarDTO;
import lk.ijse.easycar.entity.Booking;
import lk.ijse.easycar.repo.BookingRepo;
import lk.ijse.easycar.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BookingRepo repo;

    @Override
    public void saveBooking(BookingDTO dto) {
        if (repo.existsById(dto.getBk_id())){
            throw new RuntimeException("Booking id id exist!");
        }
        repo.save(mapper.map(dto, Booking.class));

    }

    @Override
    public void deleteBooking(String bk_id) {
        if (!repo.existsById(bk_id)){
            throw new RuntimeException("Booking id is not exist!");
        }
        repo.deleteById(bk_id);
    }

    @Override
    public void updateBooking(BookingDTO dto) {
        if (!repo.existsById(dto.getBk_id())){
            throw new RuntimeException("Booking id is not exist!");
        }
        repo.save(mapper.map(dto, Booking.class));
    }

    @Override
    public ArrayList<BookingDTO> getAllBooking() {
        List<Booking> all = repo.findAll();
        ArrayList<BookingDTO> allList = mapper.map(all, new TypeToken<ArrayList<BookingDTO>>(){}.getType());
        return allList;
    }

    @Override
    public int countBooking() {
        return repo.countBooking();
    }

    @Override
    public BookingDTO findBooking(String bk_id) {
        Optional<Booking> byId = repo.findById(bk_id);
        return mapper.map(byId, BookingDTO.class);
    }

    @Override
    public String generateBookingIds() {
        String id = repo.generateBookingIds();
        if (id != null) {
            int tempId = Integer.
                    parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "BK-00" + tempId;
            } else if (tempId <= 99) {
                return "BK-0" + tempId;
            } else {
                return "BK-" + tempId;
            }
        } else {
            return "BK-001";
        }
    }
}
