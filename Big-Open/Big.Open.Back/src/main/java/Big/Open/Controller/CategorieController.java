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
import big.open.payload.request.CategorieRequest;
import big.open.payload.response.CategorieResponseFindById;
import big.open.payload.response.CategorieResponseSave;
import big.open.service.CategorieService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/categorie")
public class CategorieController 
{
	@Autowired
	CategorieService categorieService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<CategorieResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(categorieService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<CategorieResponseSave> save(@Valid @RequestBody CategorieRequest categorieRequest) 
	{
		return ResponseEntity.ok(categorieService.save(categorieRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(categorieService.delete(id));
	}
}
