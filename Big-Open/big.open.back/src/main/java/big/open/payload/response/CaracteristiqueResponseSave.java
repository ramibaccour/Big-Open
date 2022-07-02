package big.open.payload.response;
import big.open.payload.response.error.CaracteristiqueResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CaracteristiqueResponseSave
{
	private CaracteristiqueResponse caracteristiqueResponse;
	private CaracteristiqueResponseError caracteristiqueResponseError;
	private String message;
	public CaracteristiqueResponseSave(CaracteristiqueResponse caracteristiqueResponse)
	{
		super();
		this.caracteristiqueResponse = caracteristiqueResponse;
	}
	public CaracteristiqueResponseSave(CaracteristiqueResponseError caracteristiqueResponseError) 
	{
		super();
		this.caracteristiqueResponseError = caracteristiqueResponseError;
	}
	public CaracteristiqueResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
