package buyerdemo.application.Buyerapp.repository;

import buyerdemo.application.Buyerapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findById(Long userId);

    void deleteById(Long userId);

}
