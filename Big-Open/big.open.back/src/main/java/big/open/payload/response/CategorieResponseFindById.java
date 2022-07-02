package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategorieResponseFindById
{
	private CategorieResponse categorieResponse;
	private String message;
	public CategorieResponseFindById(CategorieResponse categorieResponse)
	{
		super();
		this.categorieResponse = categorieResponse;
	}
	public CategorieResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
