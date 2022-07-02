package big.open.payload.response;
import big.open.payload.response.error.DepotResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepotResponseSave
{
	private DepotResponse depotResponse;
	private DepotResponseError depotResponseError;
	private String message;
	public DepotResponseSave(DepotResponse depotResponse)
	{
		super();
		this.depotResponse = depotResponse;
	}
	public DepotResponseSave(DepotResponseError depotResponseError) 
	{
		super();
		this.depotResponseError = depotResponseError;
	}
	public DepotResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
