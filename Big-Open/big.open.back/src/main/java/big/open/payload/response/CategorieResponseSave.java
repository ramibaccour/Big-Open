package big.open.payload.response;
import big.open.payload.response.error.CategorieResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategorieResponseSave
{
	private CategorieResponse categorieResponse;
	private CategorieResponseError categorieResponseError;
	private String message;
	public CategorieResponseSave(CategorieResponse categorieResponse)
	{
		super();
		this.categorieResponse = categorieResponse;
	}
	public CategorieResponseSave(CategorieResponseError categorieResponseError) 
	{
		super();
		this.categorieResponseError = categorieResponseError;
	}
	public CategorieResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
