package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepotResponseFindById
{
	private DepotResponse depotResponse;
	private String message;
	public DepotResponseFindById(DepotResponse depotResponse)
	{
		super();
		this.depotResponse = depotResponse;
	}
	public DepotResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
