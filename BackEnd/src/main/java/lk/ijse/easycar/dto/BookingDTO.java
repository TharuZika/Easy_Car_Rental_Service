package lk.ijse.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingDTO {
    private String bk_id;
    private String bk_cusnic;
    private String bk_cusname;
    private String bk_carreg;
    private String bk_carmake;
    private String bk_model;
    private String bk_withdriver;
    private String bk_drlic;
    private String bk_drname;
    private String bk_date;
    private String bk_ndate;
    private Double bk_total;
    private String bk_adminstatus;
}
