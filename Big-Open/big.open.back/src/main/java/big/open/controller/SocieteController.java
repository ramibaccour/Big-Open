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
import big.open.payload.request.SocieteRequest;
import big.open.payload.response.SocieteResponseFindById;
import big.open.payload.response.SocieteResponseSave;
import big.open.service.SocieteService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/societe")
public class SocieteController 
{
	@Autowired
	SocieteService societeService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<SocieteResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(societeService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<SocieteResponseSave> save(@Valid @RequestBody SocieteRequest societeRequest) 
	{
		return ResponseEntity.ok(societeService.save(societeRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(societeService.delete(id));
	}
}
