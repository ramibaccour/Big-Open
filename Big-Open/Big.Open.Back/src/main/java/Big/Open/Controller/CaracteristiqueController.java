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
import big.open.payload.request.CaracteristiqueRequest;
import big.open.payload.response.CaracteristiqueResponseFindById;
import big.open.payload.response.CaracteristiqueResponseSave;
import big.open.service.CaracteristiqueService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/caracteristique")
public class CaracteristiqueController 
{
	@Autowired
	CaracteristiqueService caracteristiqueService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<CaracteristiqueResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(caracteristiqueService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<CaracteristiqueResponseSave> save(@Valid @RequestBody CaracteristiqueRequest caracteristiqueRequest) 
	{
		return ResponseEntity.ok(caracteristiqueService.save(caracteristiqueRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(caracteristiqueService.delete(id));
	}
}
