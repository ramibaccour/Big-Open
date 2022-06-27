package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Document;
@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>
{
	
}
