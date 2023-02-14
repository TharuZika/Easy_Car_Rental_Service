package lk.ijse.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Driver {

    @Id
    private String dr_id;
    private String dr_name;
    private String dr_lic;
    private String dr_contact;
    private Boolean dr_avail;
}
