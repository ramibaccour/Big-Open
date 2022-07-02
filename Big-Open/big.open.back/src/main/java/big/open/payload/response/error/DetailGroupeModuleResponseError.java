package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailGroupeModuleResponseError
{
	private String id;
	private String valeur;
	private boolean have_error;
}
