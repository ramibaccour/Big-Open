package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDocumentResponseError
{
	private String id;
	private String nomArticle;
	private String referenceInterne;
	private String nomUnite;
	private String quantiteArticle;
	private String articlePrix;
	private String tauxTva;
	private String totalHt;
	private boolean have_error;
}
