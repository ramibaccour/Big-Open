package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CollaborateurResponseError
{
	private String id;
	private String raisonSociale;
	private String matriculeFiscal;
	private String delaiPaiement;
	private String uniteDelaiPaiement;
	private String typeArticlePrix;
	private String typeCollaborateur;
	private boolean have_error;
}
