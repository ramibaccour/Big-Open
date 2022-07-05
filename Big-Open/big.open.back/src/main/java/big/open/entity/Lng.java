package big.open.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;
import lombok.Data;
import javax.validation.constraints.NotNull;
@Data
@Entity
@Table(name = "lng")
public class Lng 
{
	@NotNull()
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="rtl")
	private boolean rtl;
	@Column(name="by_default")
	private boolean byDefault;
	private List<User> listUser;
}
