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
import big.open.payload.request.ArticleCategorieRequest;
import big.open.payload.response.ArticleCategorieResponseFindById;
import big.open.payload.response.ArticleCategorieResponseSave;
import big.open.service.ArticleCategorieService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/article_categorie")
public class ArticleCategorieController 
{
	@Autowired
	ArticleCategorieService articleCategorieService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<ArticleCategorieResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(articleCategorieService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<ArticleCategorieResponseSave> save(@Valid @RequestBody ArticleCategorieRequest articleCategorieRequest) 
	{
		return ResponseEntity.ok(articleCategorieService.save(articleCategorieRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(articleCategorieService.delete(id));
	}
}
