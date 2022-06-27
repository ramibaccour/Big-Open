package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TvaResponseFindById
{
	private TvaResponse tvaResponse;
	private String message;
	public TvaResponseFindById(TvaResponse tvaResponse)
	{
		super();
		this.tvaResponse = tvaResponse;
	}
	public TvaResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
