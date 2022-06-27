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
import big.open.payload.request.TvaRequest;
import big.open.payload.response.TvaResponseFindById;
import big.open.payload.response.TvaResponseSave;
import big.open.service.TvaService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tva")
public class TvaController 
{
	@Autowired
	TvaService tvaService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<TvaResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(tvaService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<TvaResponseSave> save(@Valid @RequestBody TvaRequest tvaRequest) 
	{
		return ResponseEntity.ok(tvaService.save(tvaRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(tvaService.delete(id));
	}
}
