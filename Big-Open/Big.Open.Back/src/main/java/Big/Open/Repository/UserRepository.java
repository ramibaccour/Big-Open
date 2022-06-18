package big.open.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	Optional<User> findByUsername(String username);
}
