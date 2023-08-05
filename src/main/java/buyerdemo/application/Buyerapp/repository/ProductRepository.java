package buyerdemo.application.Buyerapp.repository;

import buyerdemo.application.Buyerapp.entities.Product;
import buyerdemo.application.Buyerapp.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "UPDATE product\n" +
            "SET status = CASE\n" +
            "    WHEN status = :status THEN 'INACTIVE'\n" +
            "    WHEN status = :status THEN 'ACTIVE'\n" +
            "    ELSE status\n" +
            "  END\n" +
            "WHERE id = :id;", nativeQuery = true)
    void updateStatusForProduct(Long id, Status status);

    @Query(value = "update product set status = 'DELETED' where id=:id", nativeQuery = true)
    void deleteProduct(Long id);

}
