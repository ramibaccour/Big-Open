package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.CollaborateurPersonne;
@Repository
public interface CollaborateurPersonneRepository extends JpaRepository<CollaborateurPersonne, Integer>
{
	
}
