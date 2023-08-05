package buyerdemo.application.Buyerapp.repository;

import buyerdemo.application.Buyerapp.entities.Company;
import buyerdemo.application.Buyerapp.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {


    @Query(value = "UPDATE company\n" +
            "SET status = CASE\n" +
            "    WHEN status = :status THEN 'INACTIVE'\n" +
            "    WHEN status = :status THEN 'ACTIVE'\n" +
            "    ELSE status\n" +
            "  END\n" +
            "WHERE id = :id;", nativeQuery = true)
    void updateStatus(Long id, Status status);

    @Query(value = "update company set status = 'DELETED' where id=:id", nativeQuery = true)
    void deleteCompany(Long id);

}
