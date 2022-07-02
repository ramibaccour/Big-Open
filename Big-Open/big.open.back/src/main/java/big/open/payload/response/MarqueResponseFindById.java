package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarqueResponseFindById
{
	private MarqueResponse marqueResponse;
	private String message;
	public MarqueResponseFindById(MarqueResponse marqueResponse)
	{
		super();
		this.marqueResponse = marqueResponse;
	}
	public MarqueResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
