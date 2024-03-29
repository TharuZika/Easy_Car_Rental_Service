package lk.ijse.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Customer {

    @Id
    private String cus_nic;
    private String cus_name;
    private String cus_address;
    private String cus_contact;
    private String cus_email;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

}
