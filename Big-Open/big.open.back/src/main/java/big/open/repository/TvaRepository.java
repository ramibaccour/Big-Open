package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Tva;
@Repository
public interface TvaRepository extends JpaRepository<Tva, Integer>
{
	
}
