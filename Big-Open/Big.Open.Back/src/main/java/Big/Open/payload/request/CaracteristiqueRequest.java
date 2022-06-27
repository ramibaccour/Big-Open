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
public class CaracteristiqueRequest
{
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private List<ValeurCarateristiqueRequest> listValeurCarateristiqueRequest;
	public CaracteristiqueRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
