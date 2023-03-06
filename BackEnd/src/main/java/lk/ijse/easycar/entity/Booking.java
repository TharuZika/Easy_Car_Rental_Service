package lk.ijse.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Booking {

    @Id

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
