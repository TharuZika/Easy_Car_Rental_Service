package lk.ijse.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
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
    private String bk_cus;
    private String bk_car;
    private String bk_date;
    private String bk_ndate; //end date
    private BigDecimal bk_total;
    private Boolean bk_status;
}
