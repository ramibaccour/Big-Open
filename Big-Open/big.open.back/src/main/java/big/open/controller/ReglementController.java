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
import big.open.payload.request.ReglementRequest;
import big.open.payload.response.ReglementResponseFindById;
import big.open.payload.response.ReglementResponseSave;
import big.open.service.ReglementService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/reglement")
public class ReglementController 
{
	@Autowired
	ReglementService reglementService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<ReglementResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(reglementService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<ReglementResponseSave> save(@Valid @RequestBody ReglementRequest reglementRequest) 
	{
		return ResponseEntity.ok(reglementService.save(reglementRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(reglementService.delete(id));
	}
}
