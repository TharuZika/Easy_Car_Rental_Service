package lk.ijse.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class CustomerDTO {
    private String cus_nic;
    private String cus_name;
    private String cus_address;
    private String cus_contact;
    private String cus_email;
}