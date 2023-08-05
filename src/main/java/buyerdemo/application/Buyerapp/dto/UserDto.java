package buyerdemo.application.Buyerapp.dto;

import buyerdemo.application.Buyerapp.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long userId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String  phoneNumber;

    private String address;

    private String password;

    private String otp;

    private Status status;

    private Integer countWrongPasssword;

}
