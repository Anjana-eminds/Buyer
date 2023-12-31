package buyerdemo.application.Buyerapp.repository;

import buyerdemo.application.Buyerapp.entities.Status;
import buyerdemo.application.Buyerapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query(value = "UPDATE user\n" +
            "SET status = CASE\n" +
            "    WHEN status = :status THEN 'INACTIVE'\n" +
            "    WHEN status = :status THEN 'ACTIVE'\n" +
            "    ELSE status\n" +
            "  END\n" +
            "WHERE id = :id;", nativeQuery = true)
    void updateStatusForUser(Long id, Status status);

    @Query(value = "update user set status = 'DELETED' where id=:id", nativeQuery = true)
    void deleteUser(Long id);

}
