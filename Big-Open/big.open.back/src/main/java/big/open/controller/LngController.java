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
import big.open.payload.request.LngRequest;
import big.open.payload.response.LngResponseFindById;
import big.open.payload.response.LngResponseList;
import big.open.payload.response.LngResponseSave;
import big.open.service.LngService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/lng")
public class LngController 
{
	@Autowired
	LngService lngService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<LngResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(lngService.findById(id));
	}
	@GetMapping("/findAll")
	public ResponseEntity<LngResponseList> findAll()
	{
		return ResponseEntity.ok(lngService.findAll());
	}
	@PostMapping("/save")
	public ResponseEntity<LngResponseSave> save(@Valid @RequestBody LngRequest lngRequest) 
	{
		return ResponseEntity.ok(lngService.save(lngRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(lngService.delete(id));
	}
}
