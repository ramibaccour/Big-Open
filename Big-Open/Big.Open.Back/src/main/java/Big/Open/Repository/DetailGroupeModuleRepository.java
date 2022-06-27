package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.DetailGroupeModule;
@Repository
public interface DetailGroupeModuleRepository extends JpaRepository<DetailGroupeModule, Integer>
{
	
}
