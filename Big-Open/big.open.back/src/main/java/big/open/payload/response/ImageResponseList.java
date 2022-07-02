package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageResponseList
{
	private List<ImageResponse> listImageResponse;
	private Long count;
	private String message;
	public ImageResponseList(List<ImageResponse> listImageResponse, Long count)
	{
		super();
		this.listImageResponse = listImageResponse;
		this.count = count;
	}
}
