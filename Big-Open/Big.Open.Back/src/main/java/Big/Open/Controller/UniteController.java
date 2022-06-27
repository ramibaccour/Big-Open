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
import big.open.payload.request.UniteRequest;
import big.open.payload.response.UniteResponseFindById;
import big.open.payload.response.UniteResponseSave;
import big.open.service.UniteService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/unite")
public class UniteController 
{
	@Autowired
	UniteService uniteService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<UniteResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(uniteService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<UniteResponseSave> save(@Valid @RequestBody UniteRequest uniteRequest) 
	{
		return ResponseEntity.ok(uniteService.save(uniteRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(uniteService.delete(id));
	}
}
