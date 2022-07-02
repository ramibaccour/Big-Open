package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.DetailDocument;
@Repository
public interface DetailDocumentRepository extends JpaRepository<DetailDocument, Integer>
{
	
}
