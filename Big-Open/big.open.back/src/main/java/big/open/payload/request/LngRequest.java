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
public class LngRequest
{
	private Integer id;
	private String name;
	private List<UserRequest> listUser;
	public LngRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
