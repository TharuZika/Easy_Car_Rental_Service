package lk.ijse.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class CarDTO {

    private String cr_reg;
    private String cr_make;
    private String cr_model;
    private String cr_type;
    private String cr_fuel;
    private String cr_nfp; //no of passengers

    private BigDecimal cr_day;
    private BigDecimal cr_month;
    private BigDecimal cr_km;

    private String cr_avail;

}
