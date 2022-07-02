package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.ArticleTax;
@Repository
public interface ArticleTaxRepository extends JpaRepository<ArticleTax, Integer>
{
	
}
