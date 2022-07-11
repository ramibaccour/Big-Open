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
import big.open.payload.request.CollaborateurPersonneRequest;
import big.open.payload.response.CollaborateurPersonneResponseFindById;
import big.open.payload.response.CollaborateurPersonneResponseSave;
import big.open.service.CollaborateurPersonneService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/collaborateurPersonne")
public class CollaborateurPersonneController 
{
	@Autowired
	CollaborateurPersonneService collaborateurPersonneService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<CollaborateurPersonneResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(collaborateurPersonneService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<CollaborateurPersonneResponseSave> save(@Valid @RequestBody CollaborateurPersonneRequest collaborateurPersonneRequest) 
	{
		return ResponseEntity.ok(collaborateurPersonneService.save(collaborateurPersonneRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(collaborateurPersonneService.delete(id));
	}
}
