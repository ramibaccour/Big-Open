package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocieteResponse
{
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String matriculeFiscale;
	private String capitalSociete;
	private Integer idTva;
	private Integer idMonnaie;
	private Integer idImage;
	private List<CoordonneeResponse> listCoordonnee;
	private List<ImageResponse> listImage;
	public SocieteResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
