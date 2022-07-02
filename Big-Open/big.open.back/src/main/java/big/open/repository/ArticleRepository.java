package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Article;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>
{
	
}
