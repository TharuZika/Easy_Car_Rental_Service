package lk.ijse.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class DriverDTO {
    private String dr_lic;
    private String dr_name;
    private String dr_contact;
    private String dr_avail;

}

