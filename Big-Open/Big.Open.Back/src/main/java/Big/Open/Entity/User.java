package big.open.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;
import org.springframework.data.geo.Point;
import java.time.LocalDateTime;
import lombok.Data;
import javax.validation.constraints.NotNull;
@Data
@Entity
@Table(name = "user")
public class User 
{
	@NotNull()
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="is_deleted")
	private Integer isDeleted;
	@Transient	private GroupeModule groupeModule;
}
