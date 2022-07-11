package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Personne;
@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer>
{
	
}
