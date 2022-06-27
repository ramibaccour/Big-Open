package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Monnaie;
@Repository
public interface MonnaieRepository extends JpaRepository<Monnaie, Integer>
{
	
}
