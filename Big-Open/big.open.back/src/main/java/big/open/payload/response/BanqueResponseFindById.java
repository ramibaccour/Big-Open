package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BanqueResponseFindById
{
	private BanqueResponse banqueResponse;
	private String message;
	public BanqueResponseFindById(BanqueResponse banqueResponse)
	{
		super();
		this.banqueResponse = banqueResponse;
	}
	public BanqueResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
