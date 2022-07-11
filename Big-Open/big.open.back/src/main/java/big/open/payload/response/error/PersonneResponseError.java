package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonneResponseError
{
	private String id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String prenomLng1;
	private String prenomLng2;
	private String prenomLng3;
	private String civilite;
	private String type;
	private boolean haveError;
}
