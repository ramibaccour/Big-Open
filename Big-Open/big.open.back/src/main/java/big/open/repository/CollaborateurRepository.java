package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Collaborateur;
@Repository
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer>
{
	
}
