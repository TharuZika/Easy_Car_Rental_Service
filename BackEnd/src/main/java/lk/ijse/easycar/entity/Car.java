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
public class Car {

    @Id
    private String cr_reg;
    private String cr_make;
    private String cr_model;
    private String cr_type;
    private String cr_fuel;
    private String cr_nfp; //no of passengers
    private String cr_color;
    private BigDecimal cr_km;
    private BigDecimal cr_day;
    private BigDecimal cr_month;
    private Boolean cr_avail;
    private Boolean cr_rpStatus;
}
