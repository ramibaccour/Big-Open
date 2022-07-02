package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Tax;
@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer>
{
	
}
