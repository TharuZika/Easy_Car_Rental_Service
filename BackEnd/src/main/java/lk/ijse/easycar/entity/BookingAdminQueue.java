package lk.ijse.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookingAdminQueue {

    @Id
    private String bk_id;
    private String bk_cusnic;
    private String bk_cusname;
    private String bk_carreg;
    private String bk_carmake;
    private String bk_model;
    private String bk_date;
    private String bk_ndate;
    private Double bk_total;
}