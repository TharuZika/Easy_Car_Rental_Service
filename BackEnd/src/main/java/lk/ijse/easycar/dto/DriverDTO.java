package lk.ijse.easycar.dto;

public class DriverDTO {
    private String dr_lic;
    private String dr_name;
    private String dr_contact;
    private String dr_avail;

    public void setDr_lic(String dr_lic) {
        this.dr_lic = dr_lic;
    }

    public void setDr_name(String dr_name) {
        this.dr_name = dr_name;
    }

    public void setDr_contact(String dr_contact) {
        this.dr_contact = dr_contact;
    }

    public void setDr_avail(String dr_avail) {
        this.dr_avail = dr_avail;
    }

    public String getDr_lic() {
        return dr_lic;
    }

    public String getDr_name() {
        return dr_name;
    }

    public String getDr_contact() {
        return dr_contact;
    }

    public String getDr_avail() {
        return dr_avail;
    }

    public DriverDTO() {
    }

    public DriverDTO( String dr_lic, String dr_name, String dr_contact, String dr_avail) {
        this.dr_lic = dr_lic;
        this.dr_name = dr_name;
        this.dr_contact = dr_contact;
        this.dr_avail = dr_avail;
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                ", dr_lic='" + dr_lic + '\'' +
                ", dr_name='" + dr_name + '\'' +
                ", dr_contact='" + dr_contact + '\'' +
                ", dr_avail=" + dr_avail +
                '}';
    }

}

