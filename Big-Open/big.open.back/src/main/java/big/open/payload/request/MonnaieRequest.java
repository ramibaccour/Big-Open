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
public class MonnaieRequest
{
	private Integer page;
	private Integer size;
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private ImageRequest image;
	public MonnaieRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
