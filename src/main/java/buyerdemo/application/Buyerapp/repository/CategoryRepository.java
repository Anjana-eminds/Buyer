package buyerdemo.application.Buyerapp.repository;

import buyerdemo.application.Buyerapp.entities.Category;
import buyerdemo.application.Buyerapp.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "UPDATE category\n" +
            "SET status = CASE\n" +
            "    WHEN status = :status THEN 'INACTIVE'\n" +
            "    WHEN status = :status THEN 'ACTIVE'\n" +
            "    ELSE status\n" +
            "  END\n" +
            "WHERE id = :id;", nativeQuery = true)
    void updateStatusForCategory(Long id, Status status);

    @Query(value = "update category set status = 'DELETED' where id=:id", nativeQuery = true)
    void deleteCategory(Long id);

}
