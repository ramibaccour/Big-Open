package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocieteRequest
{
	private Integer page;
	private Integer size;
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String matriculeFiscale;
	private String capitalSociete;
	private Integer idTva;
	private Integer idMonnaie;
	private Integer idImage;
	private Integer idDefaultMenu;
	private List<CoordonneeRequest> listCoordonnee;
	private List<ImageRequest> listImage;
	public SocieteRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
