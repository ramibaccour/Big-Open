package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoordonneeResponseError
{
	private String id;
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
	private boolean haveError;
}
