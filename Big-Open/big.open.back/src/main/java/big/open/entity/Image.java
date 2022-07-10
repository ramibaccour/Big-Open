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
@Table(name = "image")
public class Image 
{
	@NotNull()
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="nom")
	private String nom;
	@Column(name="extention_image")
	private String extentionImage;
	@Column(name="resolution")
	private String resolution;
	@Column(name="type")
	private String type;
	@Column(name="type_objet")
	private String typeObjet;
	@Transient
	private Article article;
	@Transient
	private Categorie categorie;
	@Transient
	private Collaborateur collaborateur;
	@Transient
	private Societe societe;
	@Transient
	private List<Monnaie> listMonnaie;
}
