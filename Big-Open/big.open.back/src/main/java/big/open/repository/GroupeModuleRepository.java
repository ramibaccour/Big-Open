package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.GroupeModule;
@Repository
public interface GroupeModuleRepository extends JpaRepository<GroupeModule, Integer>
{
	
}
