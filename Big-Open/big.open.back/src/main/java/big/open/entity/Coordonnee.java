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
@Table(name = "coordonnee")
public class Coordonnee 
{
	@NotNull()
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="adresse_ln1")
	private String adresseLn1;
	@Column(name="adresse_ln2")
	private String adresseLn2;
	@Column(name="adresse_ln3")
	private String adresseLn3;
	@Column(name="code_postal")
	private String codePostal;
	@Column(name="ville_lng1")
	private String villeLng1;
	@Column(name="ville_lng2")
	private String villeLng2;
	@Column(name="ville_lng3")
	private String villeLng3;
	@Column(name="region_lng1")
	private String regionLng1;
	@Column(name="region_lng2")
	private String regionLng2;
	@Column(name="region_lng3")
	private String regionLng3;
	@Column(name="pays_lng1")
	private String paysLng1;
	@Column(name="pays_lng3")
	private String paysLng3;
	@Column(name="pays_lng2")
	private String paysLng2;
	@Column(name="telephone")
	private String telephone;
	@Column(name="faxe")
	private String faxe;
	@Column(name="mobile")
	private String mobile;
	@Column(name="email")
	private String email;
	@Column(name="site_web")
	private String siteWeb;
	@Column(name="type_objet")
	private String typeObjet;
	@Transient
	private Collaborateur collaborateur;
	@Transient
	private Societe societe;
	@Transient
	private List<Depot> listDepot;
}
