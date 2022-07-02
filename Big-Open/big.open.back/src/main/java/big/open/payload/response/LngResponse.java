package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LngResponse
{
	private Integer id;
	private String name;
	private List<UserResponse> listUser;
	public LngResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
