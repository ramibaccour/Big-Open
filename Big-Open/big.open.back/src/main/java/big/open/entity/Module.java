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
@Table(name = "module")
public class Module 
{
	@NotNull()
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="nom_lng1")
	private String nomLng1;
	@Column(name="nom_lng2")
	private String nomLng2;
	@Column(name="nom_lng3")
	private String nomLng3;
	@Transient
	private Module module;
	@Transient
	private List<DetailGroupeModule> listDetailGroupeModule;
	@Transient
	private List<Module> listModule;
}
