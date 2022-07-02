package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticlePrixResponseError
{
	private String id;
	private String prix;
	private String ttcHt;
	private boolean have_error;
}
