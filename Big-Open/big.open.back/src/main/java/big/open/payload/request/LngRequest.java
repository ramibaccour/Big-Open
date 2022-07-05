package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LngRequest
{
	private Integer id;
	private String name;
	private boolean rtl;
	private boolean byDefault;
	private List<UserRequest> listUser;
	public LngRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
