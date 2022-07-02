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
import big.open.payload.request.MarqueRequest;
import big.open.payload.response.MarqueResponseFindById;
import big.open.payload.response.MarqueResponseSave;
import big.open.service.MarqueService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/marque")
public class MarqueController 
{
	@Autowired
	MarqueService marqueService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<MarqueResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(marqueService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<MarqueResponseSave> save(@Valid @RequestBody MarqueRequest marqueRequest) 
	{
		return ResponseEntity.ok(marqueService.save(marqueRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(marqueService.delete(id));
	}
}
