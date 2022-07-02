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
import big.open.payload.request.DetailDocumentRequest;
import big.open.payload.response.DetailDocumentResponseFindById;
import big.open.payload.response.DetailDocumentResponseSave;
import big.open.service.DetailDocumentService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/detail_document")
public class DetailDocumentController 
{
	@Autowired
	DetailDocumentService detailDocumentService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<DetailDocumentResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(detailDocumentService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<DetailDocumentResponseSave> save(@Valid @RequestBody DetailDocumentRequest detailDocumentRequest) 
	{
		return ResponseEntity.ok(detailDocumentService.save(detailDocumentRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(detailDocumentService.delete(id));
	}
}
