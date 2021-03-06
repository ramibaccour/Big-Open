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
import big.open.payload.request.ValeurCarateristiqueRequest;
import big.open.payload.response.ValeurCarateristiqueResponseFindById;
import big.open.payload.response.ValeurCarateristiqueResponseSave;
import big.open.service.ValeurCarateristiqueService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/valeurCarateristique")
public class ValeurCarateristiqueController 
{
	@Autowired
	ValeurCarateristiqueService valeurCarateristiqueService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<ValeurCarateristiqueResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(valeurCarateristiqueService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<ValeurCarateristiqueResponseSave> save(@Valid @RequestBody ValeurCarateristiqueRequest valeurCarateristiqueRequest) 
	{
		return ResponseEntity.ok(valeurCarateristiqueService.save(valeurCarateristiqueRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(valeurCarateristiqueService.delete(id));
	}
}
