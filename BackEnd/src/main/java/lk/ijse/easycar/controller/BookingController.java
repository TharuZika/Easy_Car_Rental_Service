package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.BookingDTO;
import lk.ijse.easycar.repo.BookingRepo;
import lk.ijse.easycar.service.BookingService;
import lk.ijse.easycar.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BookingService service;

    @GetMapping(path = "/count")
    public ResponseUtil countBooking(){
        return new ResponseUtil("Ok", "Successfully Counted!", service.countBooking());
    }

    @GetMapping(path = "/getall")
    public ResponseUtil getAllBooking(){
        return new ResponseUtil("Ok", "Successfully Loaded!", service.getAllBooking());
    }

    @GetMapping(path = "/findbooking")
    public ResponseUtil findBooking(String bk_id){
        return new ResponseUtil("Ok", "Successfully Loaded!", service.findBooking(bk_id));
    }

    @PostMapping(path = "/save")
    public ResponseUtil saveBooking(@RequestBody BookingDTO dto){
        service.saveBooking(dto);
        return new ResponseUtil("Ok", "Successfully Saved!", null);
    }

    @PutMapping(path = "/update")
    public ResponseUtil updateBooking(@RequestBody BookingDTO dto){
        service.updateBooking(dto);
        return new ResponseUtil("Ok", "Successfully Updated!", null);
    }

    @GetMapping(path = "/generateid",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateBookingIds() {
        return new ResponseUtil("Ok", "Successfully Generated!", service.generateBookingIds());
    }

    @DeleteMapping(path = "/delete")
    public ResponseUtil deleteBooking(String bk_id){
        service.deleteBooking(bk_id);
        return new ResponseUtil("Ok", "Successfully Deleted!", null);
    }



}
