package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.ArticleCategorie;
@Repository
public interface ArticleCategorieRepository extends JpaRepository<ArticleCategorie, Integer>
{
	
}
