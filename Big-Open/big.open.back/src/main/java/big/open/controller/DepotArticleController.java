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
import big.open.payload.request.DepotArticleRequest;
import big.open.payload.response.DepotArticleResponseFindById;
import big.open.payload.response.DepotArticleResponseSave;
import big.open.service.DepotArticleService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/depotArticle")
public class DepotArticleController 
{
	@Autowired
	DepotArticleService depotArticleService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<DepotArticleResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(depotArticleService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<DepotArticleResponseSave> save(@Valid @RequestBody DepotArticleRequest depotArticleRequest) 
	{
		return ResponseEntity.ok(depotArticleService.save(depotArticleRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(depotArticleService.delete(id));
	}
}
