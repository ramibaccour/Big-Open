package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocieteResponseFindById
{
	private SocieteResponse societeResponse;
	private String message;
	public SocieteResponseFindById(SocieteResponse societeResponse)
	{
		super();
		this.societeResponse = societeResponse;
	}
	public SocieteResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
