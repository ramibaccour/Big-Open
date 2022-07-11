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
import big.open.payload.request.PersonneRequest;
import big.open.payload.response.PersonneResponseFindById;
import big.open.payload.response.PersonneResponseSave;
import big.open.service.PersonneService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/personne")
public class PersonneController 
{
	@Autowired
	PersonneService personneService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<PersonneResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(personneService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<PersonneResponseSave> save(@Valid @RequestBody PersonneRequest personneRequest) 
	{
		return ResponseEntity.ok(personneService.save(personneRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(personneService.delete(id));
	}
}
