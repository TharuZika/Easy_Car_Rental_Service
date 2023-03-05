package lk.ijse.easycar.service;

import lk.ijse.easycar.dto.AdminDTO;
import lk.ijse.easycar.entity.Admin;

import java.util.ArrayList;

public interface AdminService {

    public void saveAdmin(String adminId, String adminName);

    public void updateAdmin(AdminDTO dto);

    public void deleteAdmin(String adminId);

    public ArrayList<AdminDTO> getAllAdmins();

    public AdminDTO findByAdminId(String adminId);

    public String generateAdminId();

}
