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
import big.open.payload.request.CollaborateurRequest;
import big.open.payload.response.CollaborateurResponseFindById;
import big.open.payload.response.CollaborateurResponseSave;
import big.open.service.CollaborateurService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/collaborateur")
public class CollaborateurController 
{
	@Autowired
	CollaborateurService collaborateurService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<CollaborateurResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(collaborateurService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<CollaborateurResponseSave> save(@Valid @RequestBody CollaborateurRequest collaborateurRequest) 
	{
		return ResponseEntity.ok(collaborateurService.save(collaborateurRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(collaborateurService.delete(id));
	}
}
