package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LngResponse
{
	private Integer id;
	private String name;
	private boolean rtl;
	private boolean byDefault;
	private String code;
	private String attribut;
	private List<UserResponse> listUser;
	public LngResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
