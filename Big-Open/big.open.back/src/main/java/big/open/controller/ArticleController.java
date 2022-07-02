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
import big.open.payload.request.ArticleRequest;
import big.open.payload.response.ArticleResponseFindById;
import big.open.payload.response.ArticleResponseSave;
import big.open.service.ArticleService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/article")
public class ArticleController 
{
	@Autowired
	ArticleService articleService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<ArticleResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(articleService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<ArticleResponseSave> save(@Valid @RequestBody ArticleRequest articleRequest) 
	{
		return ResponseEntity.ok(articleService.save(articleRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(articleService.delete(id));
	}
}
