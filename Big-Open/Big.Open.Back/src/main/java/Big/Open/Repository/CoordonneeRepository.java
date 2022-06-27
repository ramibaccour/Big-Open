package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Coordonnee;
@Repository
public interface CoordonneeRepository extends JpaRepository<Coordonnee, Integer>
{
	
}
