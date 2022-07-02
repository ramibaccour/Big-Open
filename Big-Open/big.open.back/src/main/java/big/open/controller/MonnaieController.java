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
import big.open.payload.request.MonnaieRequest;
import big.open.payload.response.MonnaieResponseFindById;
import big.open.payload.response.MonnaieResponseSave;
import big.open.service.MonnaieService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/monnaie")
public class MonnaieController 
{
	@Autowired
	MonnaieService monnaieService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<MonnaieResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(monnaieService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<MonnaieResponseSave> save(@Valid @RequestBody MonnaieRequest monnaieRequest) 
	{
		return ResponseEntity.ok(monnaieService.save(monnaieRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(monnaieService.delete(id));
	}
}
