package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Image;
import big.open.payload.request.ImageRequest;
import big.open.payload.response.ImageResponse;
import big.open.payload.response.ImageResponseFindById;
import big.open.payload.response.ImageResponseSave;
import big.open.payload.response.error.ImageResponseError;
import big.open.repository.ImageRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class ImageService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ImageRepository imageRepository;
	public ImageResponseFindById findById(Integer id)
	{
		Optional<Image> image = imageRepository.findById(id);
		if(image.isPresent())
		{
			ImageResponse imageResponse = ObjectMapperUtility.map(image.get(),ImageResponse.class);
			return new ImageResponseFindById(imageResponse);
		}
		return new ImageResponseFindById("");
	}
	public ImageResponseSave save(ImageRequest imageRequest)
	{
		ImageResponseError imageResponseError = checkImageResponseError(imageRequest);
		if(imageResponseError.isHaveError())
		{
			return new ImageResponseSave(imageResponseError);
		}
		else
		{
			try
			{
				Image image = imageRepository.save(ObjectMapperUtility.map(imageRequest, Image.class));
				return  new ImageResponseSave(ObjectMapperUtility.map(image, ImageResponse.class));
			}
			catch(Exception e)
			{
				imageResponseError.setHaveError(true);
				return  new ImageResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var image = imageRepository.findById(id);
			imageRepository.save(image.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private ImageResponseError checkImageResponseError (ImageRequest imageRequest)
	{
		ImageResponseError imageResponseError = new ImageResponseError();
		imageResponseError.setHaveError(false);
		if(Utility.isEmpty(imageRequest.getId()) )
		{
			imageRequest.setId(-1);
		}
		//if(Utility.isEmpty(imageRequest.get()) )
		//{
				//imageResponseError.setHaveError(true);
				//imageResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return imageResponseError;
	}
}
