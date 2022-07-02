package big.open.payload.response;
import big.open.payload.response.error.CoordonneeResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoordonneeResponseSave
{
	private CoordonneeResponse coordonneeResponse;
	private CoordonneeResponseError coordonneeResponseError;
	private String message;
	public CoordonneeResponseSave(CoordonneeResponse coordonneeResponse)
	{
		super();
		this.coordonneeResponse = coordonneeResponse;
	}
	public CoordonneeResponseSave(CoordonneeResponseError coordonneeResponseError) 
	{
		super();
		this.coordonneeResponseError = coordonneeResponseError;
	}
	public CoordonneeResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
