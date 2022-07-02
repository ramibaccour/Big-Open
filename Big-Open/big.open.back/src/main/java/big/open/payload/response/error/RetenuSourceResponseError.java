package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RetenuSourceResponseError
{
	private String id;
	private String taux;
	private String type;
	private boolean haveError;
}
