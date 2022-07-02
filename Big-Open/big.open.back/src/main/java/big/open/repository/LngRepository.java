package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Lng;
@Repository
public interface LngRepository extends JpaRepository<Lng, Integer>
{
	
}
