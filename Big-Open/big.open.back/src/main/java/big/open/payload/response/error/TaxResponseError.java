package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaxResponseError
{
	private String id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String type;
	private String signe;
	private String valeur;
	private String group;
	private String calculerAvantTva;
	private boolean haveError;
}
