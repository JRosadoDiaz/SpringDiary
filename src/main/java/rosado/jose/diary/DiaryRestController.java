package rosado.jose.diary;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/diary")
public class DiaryRestController {
	
	@Autowired
	private DiaryEntryRepository repo;

	@RequestMapping(path="", method=RequestMethod.POST)
	public void createDiaryEntry(@RequestBody DiaryEntry entry) throws JsonParseException, JsonMappingException, IOException {
		entry.setCreateDate(LocalDateTime.now());
		repo.save(entry);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<DiaryEntry> findAllEntries() throws JsonParseException, JsonMappingException, IOException {
		return repo.findAll();
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public DiaryEntry findEntryById(@PathVariable int id) throws JsonParseException, JsonMappingException, IOException {
		return repo.findById(id).orElse(null);
	}
	
//	@RequestMapping(path="/echo", method=RequestMethod.GET)
//	public String echo(@RequestParam String text) {
//		return text;
//	}
}
