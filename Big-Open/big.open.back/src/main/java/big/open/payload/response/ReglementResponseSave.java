package big.open.payload.response;
import big.open.payload.response.error.ReglementResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReglementResponseSave
{
	private ReglementResponse reglementResponse;
	private ReglementResponseError reglementResponseError;
	private String message;
	public ReglementResponseSave(ReglementResponse reglementResponse)
	{
		super();
		this.reglementResponse = reglementResponse;
	}
	public ReglementResponseSave(ReglementResponseError reglementResponseError) 
	{
		super();
		this.reglementResponseError = reglementResponseError;
	}
	public ReglementResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
