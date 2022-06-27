package big.open.payload.response;
import big.open.payload.response.error.ImageResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageResponseSave
{
	private ImageResponse imageResponse;
	private ImageResponseError imageResponseError;
	private String message;
	public ImageResponseSave(ImageResponse imageResponse)
	{
		super();
		this.imageResponse = imageResponse;
	}
	public ImageResponseSave(ImageResponseError imageResponseError) 
	{
		super();
		this.imageResponseError = imageResponseError;
	}
	public ImageResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
