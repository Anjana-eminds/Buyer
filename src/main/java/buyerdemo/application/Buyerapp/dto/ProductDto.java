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
public class ProductDto {

    private Integer id;

    private Integer categoryName;

    private String name;

    private Integer price;

    private Status status;

    private String discount;

    private Integer discountPrice;

    private Integer stock;

    private Date createdAt;

    private Date updatedAt;

}
