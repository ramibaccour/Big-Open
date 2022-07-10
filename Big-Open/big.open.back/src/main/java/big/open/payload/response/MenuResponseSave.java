package big.open.payload.response;
import big.open.payload.response.error.MenuResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuResponseSave
{
	private MenuResponse menuResponse;
	private MenuResponseError menuResponseError;
	private String message;
	public MenuResponseSave(MenuResponse menuResponse)
	{
		super();
		this.menuResponse = menuResponse;
	}
	public MenuResponseSave(MenuResponseError menuResponseError) 
	{
		super();
		this.menuResponseError = menuResponseError;
	}
	public MenuResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
