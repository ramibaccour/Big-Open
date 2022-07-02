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
import big.open.payload.request.ArticlePrixRequest;
import big.open.payload.response.ArticlePrixResponseFindById;
import big.open.payload.response.ArticlePrixResponseSave;
import big.open.service.ArticlePrixService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/articlePrix")
public class ArticlePrixController 
{
	@Autowired
	ArticlePrixService articlePrixService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<ArticlePrixResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(articlePrixService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<ArticlePrixResponseSave> save(@Valid @RequestBody ArticlePrixRequest articlePrixRequest) 
	{
		return ResponseEntity.ok(articlePrixService.save(articlePrixRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(articlePrixService.delete(id));
	}
}
