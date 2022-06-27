package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Marque;
@Repository
public interface MarqueRepository extends JpaRepository<Marque, Integer>
{
	
}
