package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.geo.Point;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValeurCarateristiqueRequest
{
	private Integer id;
	private String valeur;
	private CaracteristiqueRequest caracteristique;
	public ValeurCarateristiqueRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
