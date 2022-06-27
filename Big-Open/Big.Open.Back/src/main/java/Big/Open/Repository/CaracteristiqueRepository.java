package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Caracteristique;
@Repository
public interface CaracteristiqueRepository extends JpaRepository<Caracteristique, Integer>
{
	
}
