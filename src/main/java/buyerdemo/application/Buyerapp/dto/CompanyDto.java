package buyerdemo.application.Buyerapp.dto;

import buyerdemo.application.Buyerapp.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDto {

    private Long userId;

    private String name;

    private String email;

    private String phoneNumber;

    private String address;

    private String password;

    private String otp;

    private Status status;

    private Integer countWrongPasssword;

    private java.util.Date createdAt;

    private Date updatedAt;

}
