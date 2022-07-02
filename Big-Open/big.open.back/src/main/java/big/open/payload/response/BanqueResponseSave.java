package big.open.payload.response;
import big.open.payload.response.error.BanqueResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BanqueResponseSave
{
	private BanqueResponse banqueResponse;
	private BanqueResponseError banqueResponseError;
	private String message;
	public BanqueResponseSave(BanqueResponse banqueResponse)
	{
		super();
		this.banqueResponse = banqueResponse;
	}
	public BanqueResponseSave(BanqueResponseError banqueResponseError) 
	{
		super();
		this.banqueResponseError = banqueResponseError;
	}
	public BanqueResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
