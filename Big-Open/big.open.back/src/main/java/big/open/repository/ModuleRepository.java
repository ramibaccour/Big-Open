package big.open.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import big.open.entity.Module;
@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer>
{
	
}
