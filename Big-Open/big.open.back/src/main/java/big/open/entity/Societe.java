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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "societe")
public class Societe 
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
	@Column(name="matricule_fiscale")
	private String matriculeFiscale;
	@Column(name="capital_societe")
	private String capitalSociete;
	@Column(name="id_tva")
	private Integer idTva;
	@Column(name="id_monnaie")
	private Integer idMonnaie;
	@Column(name="id_image")
	private Integer idImage;
	@Column(name="id_default_menu")
	private Integer idDefaultMenu;
	@Transient
	private List<Coordonnee> listCoordonnee;
	@Transient
	private List<Image> listImage;
}
