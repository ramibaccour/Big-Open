package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuResponseList
{
	private List<MenuResponse> listMenuResponse;
	private Long count;
	private String message;
	public MenuResponseList(List<MenuResponse> listMenuResponse, Long count)
	{
		super();
		this.listMenuResponse = listMenuResponse;
		this.count = count;
	}
}
