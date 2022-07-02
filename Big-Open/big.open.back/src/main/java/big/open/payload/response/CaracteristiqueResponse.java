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
public class CaracteristiqueResponse
{
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private List<ValeurCarateristiqueResponse> listValeurCarateristiqueResponse;
	public CaracteristiqueResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
