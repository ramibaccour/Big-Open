package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.ValeurCarateristique;
@Repository
public interface ValeurCarateristiqueRepository extends JpaRepository<ValeurCarateristique, Integer>
{
	
}
