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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personne")
public class Personne 
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
	@Column(name="prenom_lng1")
	private String prenomLng1;
	@Column(name="prenom_lng2")
	private String prenomLng2;
	@Column(name="prenom_lng3")
	private String prenomLng3;
	@Column(name="civilite")
	private String civilite;
	@Column(name="type")
	private String type;
	@Transient
	private List<CollaborateurPersonne> listCollaborateurPersonne;
	@Transient
	private List<User> listUser;
}
