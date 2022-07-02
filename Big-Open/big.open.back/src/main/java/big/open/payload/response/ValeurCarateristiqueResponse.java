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
public class ValeurCarateristiqueResponse
{
	private Integer id;
	private String valeur;
	private CaracteristiqueResponse caracteristique;
	public ValeurCarateristiqueResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
