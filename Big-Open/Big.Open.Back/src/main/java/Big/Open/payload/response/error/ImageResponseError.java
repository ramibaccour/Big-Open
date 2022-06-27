package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageResponseError
{
	private String id;
	private String nom;
	private String extentionImage;
	private String resolution;
	private String type;
	private String typeObjet;
	private boolean have_error;
}
