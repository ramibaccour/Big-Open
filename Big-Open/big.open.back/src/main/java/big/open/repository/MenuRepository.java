package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Menu;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>
{
	
}
