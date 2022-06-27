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
import big.open.payload.request.DetailDocumentTaxRequest;
import big.open.payload.response.DetailDocumentTaxResponseFindById;
import big.open.payload.response.DetailDocumentTaxResponseSave;
import big.open.service.DetailDocumentTaxService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/detail_document_tax")
public class DetailDocumentTaxController 
{
	@Autowired
	DetailDocumentTaxService detailDocumentTaxService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<DetailDocumentTaxResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(detailDocumentTaxService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<DetailDocumentTaxResponseSave> save(@Valid @RequestBody DetailDocumentTaxRequest detailDocumentTaxRequest) 
	{
		return ResponseEntity.ok(detailDocumentTaxService.save(detailDocumentTaxRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(detailDocumentTaxService.delete(id));
	}
}
