package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocieteResponseError
{
	private String id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String matriculeFiscale;
	private String capitalSociete;
	private String idTva;
	private String idMonnaie;
	private String idImage;
	private boolean have_error;
}
