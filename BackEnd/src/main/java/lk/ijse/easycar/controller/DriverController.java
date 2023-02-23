package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.DriverDTO;
import lk.ijse.easycar.entity.Driver;
import lk.ijse.easycar.repo.DriverRepo;
import lk.ijse.easycar.service.DriverService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private DriverService service;

    @PostMapping
    public ResponseUtil saveCustomer(String dr_lic, String dr_name, String dr_contact, String dr_avail){
        Driver driver = new Driver();
        driver.setDr_lic(dr_lic);
        driver.setDr_name(dr_name);
        driver.setDr_contact(dr_contact);
        driver.setDr_avail(dr_avail);
        repo.save(driver);

        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }


}
