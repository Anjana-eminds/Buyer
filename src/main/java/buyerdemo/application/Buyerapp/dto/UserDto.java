package buyerdemo.application.Buyerapp.dto;

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
    private Integer phoneNumber;
    private String password;
    private String otp;
    private String status;
    private Integer countWrongPasssword;
    private Date createdAt;
    private Date updatedAt;
}
