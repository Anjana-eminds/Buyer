package buyerdemo.application.Buyerapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "status")
    private Status status;

    @Column(name = "discount")
    private String discount;

    @Column(name = "discount_price")
    private Integer discountPrice;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Category category;

    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Company company;

}
