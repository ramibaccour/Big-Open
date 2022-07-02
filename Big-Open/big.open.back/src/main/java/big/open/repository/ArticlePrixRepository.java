package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.ArticlePrix;
@Repository
public interface ArticlePrixRepository extends JpaRepository<ArticlePrix, Integer>
{
	
}
