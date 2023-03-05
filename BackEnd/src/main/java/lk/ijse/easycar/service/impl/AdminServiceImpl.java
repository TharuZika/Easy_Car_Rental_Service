package lk.ijse.easycar.service.impl;

import lk.ijse.easycar.dto.AdminDTO;
import lk.ijse.easycar.dto.CarDTO;
import lk.ijse.easycar.entity.Admin;
import lk.ijse.easycar.repo.AdminRepo;
import lk.ijse.easycar.service.AdminService;
import lk.ijse.easycar.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AdminRepo repo;

    @Override
    public void saveAdmin(String adminId, String adminName) {
        if (repo.existsById(adminId)){
            throw new RuntimeException("Admin Already Exists!");
        }
        Admin admin = new Admin();
        admin.setAdminId(adminId);
        admin.setAdminName(adminName);
        repo.save(admin);
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getAdminId())){
            repo.save(mapper.map(dto, Admin.class));
        }
    }

    @Override
    public void deleteAdmin(String adminId) {
        if (repo.existsById(adminId)){
            repo.deleteById(adminId);
        }
    }

    @Override
    public ArrayList<AdminDTO> getAllAdmins() {
        List<Admin> all = repo.findAll();
        ArrayList<AdminDTO> allList = mapper.map(all, new TypeToken<ArrayList<AdminDTO>>(){}.getType());
        return allList;
    }

    @Override
    public AdminDTO findByAdminId(String adminId) {
        Optional<Admin> byId = repo.findById(adminId);
        return mapper.map(byId, AdminDTO.class);
    }

    @Override
    public String generateAdminId() {
        String id = repo.generateAdminId();
        if (id != null) {
            int tempId = Integer.
                    parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "AD-00" + tempId;
            } else if (tempId <= 99) {
                return "AD-0" + tempId;
            } else {
                return "AD-" + tempId;
            }
        } else {
            return "AD-001";
        }
    }
}
