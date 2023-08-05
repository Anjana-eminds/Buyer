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
public class CategoryDto {

    private Integer id;

    private String name;

    private Date createdAt;

    private Date updatedAt;

    private Status status;

}
