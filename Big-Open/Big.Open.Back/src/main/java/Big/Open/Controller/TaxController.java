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
import big.open.payload.request.TaxRequest;
import big.open.payload.response.TaxResponseFindById;
import big.open.payload.response.TaxResponseSave;
import big.open.service.TaxService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tax")
public class TaxController 
{
	@Autowired
	TaxService taxService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<TaxResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(taxService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<TaxResponseSave> save(@Valid @RequestBody TaxRequest taxRequest) 
	{
		return ResponseEntity.ok(taxService.save(taxRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(taxService.delete(id));
	}
}
