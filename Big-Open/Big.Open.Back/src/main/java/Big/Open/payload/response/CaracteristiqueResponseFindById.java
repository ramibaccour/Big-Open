package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CaracteristiqueResponseFindById
{
	private CaracteristiqueResponse caracteristiqueResponse;
	private String message;
	public CaracteristiqueResponseFindById(CaracteristiqueResponse caracteristiqueResponse)
	{
		super();
		this.caracteristiqueResponse = caracteristiqueResponse;
	}
	public CaracteristiqueResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
