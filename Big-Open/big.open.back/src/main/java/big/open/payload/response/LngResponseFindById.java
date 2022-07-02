package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LngResponseFindById
{
	private LngResponse lngResponse;
	private String message;
	public LngResponseFindById(LngResponse lngResponse)
	{
		super();
		this.lngResponse = lngResponse;
	}
	public LngResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
