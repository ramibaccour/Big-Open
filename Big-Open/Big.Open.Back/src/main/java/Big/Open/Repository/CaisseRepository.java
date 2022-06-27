package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Caisse;
@Repository
public interface CaisseRepository extends JpaRepository<Caisse, Integer>
{
	
}
