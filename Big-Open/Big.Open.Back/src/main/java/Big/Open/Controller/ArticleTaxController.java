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
import big.open.payload.request.ArticleTaxRequest;
import big.open.payload.response.ArticleTaxResponseFindById;
import big.open.payload.response.ArticleTaxResponseSave;
import big.open.service.ArticleTaxService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/article_tax")
public class ArticleTaxController 
{
	@Autowired
	ArticleTaxService articleTaxService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<ArticleTaxResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(articleTaxService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<ArticleTaxResponseSave> save(@Valid @RequestBody ArticleTaxRequest articleTaxRequest) 
	{
		return ResponseEntity.ok(articleTaxService.save(articleTaxRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(articleTaxService.delete(id));
	}
}
