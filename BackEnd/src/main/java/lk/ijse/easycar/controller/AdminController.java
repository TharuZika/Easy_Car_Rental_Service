package lk.ijse.easycar.controller;

import lk.ijse.easycar.dto.AdminDTO;
import lk.ijse.easycar.service.AdminService;
import lk.ijse.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping(path = "/save")
    public ResponseUtil saveAdmin(@RequestParam String adminId, @RequestParam String adminName){
        service.saveAdmin(adminId, adminName);
        return new ResponseUtil("Ok", "Successfully Saved!", null);
    }

    @PutMapping(path = "/update")
    public ResponseUtil updateAdmin(@RequestBody AdminDTO dto){
        service.updateAdmin(dto);
        return new ResponseUtil("Ok", "Successfully Updated!", null);
    }

    @DeleteMapping("/delete")
    public ResponseUtil deleteAdmin(String adminId){
        service.deleteAdmin(adminId);
        return new ResponseUtil("Ok", "Successfully Deleted!", null);
    }

    @GetMapping("/getall")
    public ResponseUtil getAllAdmins(){
        return new ResponseUtil("Ok", "Successfully Updated!", service.getAllAdmins());
    }

    @GetMapping(path = "/generateid",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateAdminIds() {
        return new ResponseUtil("Ok", "Successfully Generated!", service.generateAdminId());
    }

}
