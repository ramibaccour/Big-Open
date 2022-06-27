package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Banque;
@Repository
public interface BanqueRepository extends JpaRepository<Banque, Integer>
{
	
}
