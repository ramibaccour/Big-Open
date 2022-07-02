package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.geo.Point;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoordonneeRequest
{
	private Integer id;
	private String adresseLn1;
	private String adresseLn2;
	private String adresseLn3;
	private String codePostal;
	private String villeLng1;
	private String villeLng2;
	private String villeLng3;
	private String regionLng1;
	private String regionLng2;
	private String regionLng3;
	private String paysLng1;
	private String paysLng3;
	private String paysLng2;
	private String telephone;
	private String faxe;
	private String mobile;
	private String email;
	private String siteWeb;
	private String typeObjet;
	private CollaborateurRequest collaborateur;
	private SocieteRequest societe;
	private List<DepotRequest> listDepot;
	public CoordonneeRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
