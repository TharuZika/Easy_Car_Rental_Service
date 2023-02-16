package lk.ijse.easycar.dto;

public class CustomerDTO {
    private String cus_id;
    private String cus_nic;
    private String cus_name;
    private String cus_address;
    private String cus_contact;
    private String cus_email;

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public void setCus_nic(String cus_nic) {
        this.cus_nic = cus_nic;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
    }

    public void setCus_contact(String cus_contact) {
        this.cus_contact = cus_contact;
    }

    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }

    public String getCus_id() {
        return cus_id;
    }

    public String getCus_nic() {
        return cus_nic;
    }

    public String getCus_name() {
        return cus_name;
    }

    public String getCus_address() {
        return cus_address;
    }

    public String getCus_contact() {
        return cus_contact;
    }

    public String getCus_email() {
        return cus_email;
    }

    public CustomerDTO(String cus_id, String cus_nic, String cus_name, String cus_address, String cus_contact, String cus_email) {
        this.cus_id = cus_id;
        this.cus_nic = cus_nic;
        this.cus_name = cus_name;
        this.cus_address = cus_address;
        this.cus_contact = cus_contact;
        this.cus_email = cus_email;
    }

    public CustomerDTO() {
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "cus_id='" + cus_id + '\'' +
                ", cus_nic='" + cus_nic + '\'' +
                ", cus_name='" + cus_name + '\'' +
                ", cus_address='" + cus_address + '\'' +
                ", cus_contact='" + cus_contact + '\'' +
                ", cus_email='" + cus_email + '\'' +
                '}';
    }

}
