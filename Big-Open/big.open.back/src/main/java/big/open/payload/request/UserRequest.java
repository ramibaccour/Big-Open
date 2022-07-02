package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.geo.Point;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest
{
	private Integer id;
	private String username;
	private String password;
	private Integer isDeleted;
	private GroupeModuleRequest groupeModuleRequest;
	public UserRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
