package lk.ijse.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    private String adminId;
    private String adminName;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
