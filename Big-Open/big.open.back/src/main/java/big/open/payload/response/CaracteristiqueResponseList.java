package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CaracteristiqueResponseList
{
	private List<CaracteristiqueResponse> listCaracteristiqueResponse;
	private Long count;
	private String message;
	public CaracteristiqueResponseList(List<CaracteristiqueResponse> listCaracteristiqueResponse, Long count)
	{
		super();
		this.listCaracteristiqueResponse = listCaracteristiqueResponse;
		this.count = count;
	}
}
