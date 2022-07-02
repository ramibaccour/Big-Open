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
import big.open.payload.request.DetailGroupeModuleRequest;
import big.open.payload.response.DetailGroupeModuleResponseFindById;
import big.open.payload.response.DetailGroupeModuleResponseSave;
import big.open.service.DetailGroupeModuleService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/detailGroupeModule")
public class DetailGroupeModuleController 
{
	@Autowired
	DetailGroupeModuleService detailGroupeModuleService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<DetailGroupeModuleResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(detailGroupeModuleService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<DetailGroupeModuleResponseSave> save(@Valid @RequestBody DetailGroupeModuleRequest detailGroupeModuleRequest) 
	{
		return ResponseEntity.ok(detailGroupeModuleService.save(detailGroupeModuleRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(detailGroupeModuleService.delete(id));
	}
}
