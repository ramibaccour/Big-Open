package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupeModuleResponse
{
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private boolean value;
	private ModuleResponse moduleResponse;
	private List<UserResponse> listUserResponse;
	public GroupeModuleResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
