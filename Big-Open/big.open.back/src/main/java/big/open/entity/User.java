package big.open.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User 
{
	@NotNull()
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="is_deleted")
	private Integer isDeleted;
	@ManyToOne()
	@JoinColumn(name = "id_lng")
	private Lng lng;

	@ManyToOne()
	@JoinColumn(name = "id_groupe_module")
	private GroupeModule groupeModule;

	@ManyToOne()
	@JoinColumn(name = "id_personne")
	private Personne personne;
	
}
