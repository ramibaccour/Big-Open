package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValeurCarateristiqueResponseList
{
	private List<ValeurCarateristiqueResponse> listValeurCarateristiqueResponse;
	private Long count;
	private String message;
	public ValeurCarateristiqueResponseList(List<ValeurCarateristiqueResponse> listValeurCarateristiqueResponse, Long count)
	{
		super();
		this.listValeurCarateristiqueResponse = listValeurCarateristiqueResponse;
		this.count = count;
	}
}
