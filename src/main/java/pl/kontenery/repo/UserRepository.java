package pl.kontenery.repo;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kontenery.model.data.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String name);
}
