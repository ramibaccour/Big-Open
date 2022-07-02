package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepotArticleResponseError
{
	private String id;
	private String quantite;
	private String quantiteMin;
	private String alertQuantiteMin;
	private boolean haveError;
}
