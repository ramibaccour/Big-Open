package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonnaieResponseFindById
{
	private MonnaieResponse monnaieResponse;
	private String message;
	public MonnaieResponseFindById(MonnaieResponse monnaieResponse)
	{
		super();
		this.monnaieResponse = monnaieResponse;
	}
	public MonnaieResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
