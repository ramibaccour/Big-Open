package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>
{
	
}
