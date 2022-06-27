package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReglementResponseFindById
{
	private ReglementResponse reglementResponse;
	private String message;
	public ReglementResponseFindById(ReglementResponse reglementResponse)
	{
		super();
		this.reglementResponse = reglementResponse;
	}
	public ReglementResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
