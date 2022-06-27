package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageResponseFindById
{
	private ImageResponse imageResponse;
	private String message;
	public ImageResponseFindById(ImageResponse imageResponse)
	{
		super();
		this.imageResponse = imageResponse;
	}
	public ImageResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
