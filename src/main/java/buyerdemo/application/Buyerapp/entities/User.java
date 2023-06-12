package buyerdemo.application.Buyerapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private Integer phoneNumber;

    private String password;

    private String otp;

    private String status;

    private Integer countWrongPasssword;

    private Date createdAt;

    private Date updatedAt;

}
