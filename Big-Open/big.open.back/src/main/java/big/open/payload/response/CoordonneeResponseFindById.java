package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoordonneeResponseFindById
{
	private CoordonneeResponse coordonneeResponse;
	private String message;
	public CoordonneeResponseFindById(CoordonneeResponse coordonneeResponse)
	{
		super();
		this.coordonneeResponse = coordonneeResponse;
	}
	public CoordonneeResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
