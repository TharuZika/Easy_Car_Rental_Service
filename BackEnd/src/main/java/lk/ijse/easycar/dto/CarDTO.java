package lk.ijse.easycar.dto;

import java.math.BigDecimal;

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

    private Boolean cr_avail;

//    private String cr_img;
//
//    public void setCr_img(String cr_img) {
//        this.cr_img = cr_img;
//    }
//
//    public String getCr_img() {
//        return cr_img;
//    }

    public void setCr_reg(String cr_reg) {
        this.cr_reg = cr_reg;
    }

    public void setCr_make(String cr_make) {
        this.cr_make = cr_make;
    }

    public void setCr_model(String cr_model) {
        this.cr_model = cr_model;
    }

    public void setCr_type(String cr_type) {
        this.cr_type = cr_type;
    }

    public void setCr_fuel(String cr_fuel) {
        this.cr_fuel = cr_fuel;
    }

    public void setCr_nfp(String cr_nfp) {
        this.cr_nfp = cr_nfp;
    }

    public void setCr_day(BigDecimal cr_day) {
        this.cr_day = cr_day;
    }

    public void setCr_month(BigDecimal cr_month) {
        this.cr_month = cr_month;
    }

    public void setCr_km(BigDecimal cr_km) {
        this.cr_km = cr_km;
    }

    public void setCr_avail(Boolean cr_avail) {
        this.cr_avail = cr_avail;
    }

    public String getCr_reg() {
        return cr_reg;
    }

    public String getCr_make() {
        return cr_make;
    }

    public String getCr_model() {
        return cr_model;
    }

    public String getCr_type() {
        return cr_type;
    }

    public String getCr_fuel() {
        return cr_fuel;
    }

    public String getCr_nfp() {
        return cr_nfp;
    }

    public BigDecimal getCr_day() {
        return cr_day;
    }

    public BigDecimal getCr_month() {
        return cr_month;
    }

    public BigDecimal getCr_km() {
        return cr_km;
    }

    public Boolean getCr_avail() {
        return cr_avail;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "cr_reg='" + cr_reg + '\'' +
                ", cr_make='" + cr_make + '\'' +
                ", cr_model='" + cr_model + '\'' +
                ", cr_type='" + cr_type + '\'' +
                ", cr_fuel='" + cr_fuel + '\'' +
                ", cr_nfp='" + cr_nfp + '\'' +
                ", cr_day=" + cr_day +
                ", cr_month=" + cr_month +
                ", cr_km=" + cr_km +
                ", cr_avail=" + cr_avail +
//                ", cr_img=" + cr_img +
                '}';
    }

    public CarDTO(String cr_reg, String cr_make, String cr_model, String cr_type, String cr_fuel, String cr_nfp, BigDecimal cr_day, BigDecimal cr_month, BigDecimal cr_km, Boolean cr_avail/*, String cr_img*/) {
        this.cr_reg = cr_reg;
        this.cr_make = cr_make;
        this.cr_model = cr_model;
        this.cr_type = cr_type;
        this.cr_fuel = cr_fuel;
        this.cr_nfp = cr_nfp;
        this.cr_day = cr_day;
        this.cr_month = cr_month;
        this.cr_km = cr_km;
        this.cr_avail = cr_avail;
//        this.cr_img = cr_img;
    }

    public CarDTO() {
    }
}
