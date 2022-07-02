package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.DepotArticle;
@Repository
public interface DepotArticleRepository extends JpaRepository<DepotArticle, Integer>
{
	
}
