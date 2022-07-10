package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuResponseFindById
{
	private MenuResponse menuResponse;
	private String message;
	public MenuResponseFindById(MenuResponse menuResponse)
	{
		super();
		this.menuResponse = menuResponse;
	}
	public MenuResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
