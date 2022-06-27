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
import big.open.payload.request.CaisseRequest;
import big.open.payload.response.CaisseResponseFindById;
import big.open.payload.response.CaisseResponseSave;
import big.open.service.CaisseService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/caisse")
public class CaisseController 
{
	@Autowired
	CaisseService caisseService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<CaisseResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(caisseService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<CaisseResponseSave> save(@Valid @RequestBody CaisseRequest caisseRequest) 
	{
		return ResponseEntity.ok(caisseService.save(caisseRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(caisseService.delete(id));
	}
}
