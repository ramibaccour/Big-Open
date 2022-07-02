package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleResponseError
{
	private String id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String description;
	private String codeBarre;
	private String referenceInterne;
	private String referenceFournisseur;
	private String typeArticle;
	private String isDeleted;
	private boolean haveError;
}
