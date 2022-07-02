package big.open.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import big.open.payload.request.ImageRequest;
import big.open.payload.response.ImageResponseFindById;
import big.open.payload.response.ImageResponseSave;
import big.open.service.ImageService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/image")
public class ImageController 
{
	@Autowired
	ImageService imageService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<ImageResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(imageService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<ImageResponseSave> save(@Valid @RequestBody ImageRequest imageRequest) 
	{
		return ResponseEntity.ok(imageService.save(imageRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(imageService.delete(id));
	}
}
