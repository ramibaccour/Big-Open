package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentResponseError
{
	private String id;
	private String numero;
	private String date;
	private String raisonSociale;
	private String matriculeFiscal;
	private String typeDocument;
	private String totalHt;
	private String totalTva;
	private String totalTtc;
	private boolean haveError;
}
