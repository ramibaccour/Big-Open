package Big.Open.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Big.Open.Entity.User;


@Repository
public interface UserRepository extends JpaRepository<User , Integer>
{
	Optional<User> findByUsernameAndIsArchived(String username, Integer isArchived);
}
