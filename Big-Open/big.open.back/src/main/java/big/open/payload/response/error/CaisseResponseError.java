package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CaisseResponseError
{
	private String id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String valeur;
	private boolean haveError;
}
