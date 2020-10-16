package rosado.jose.diary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DiaryEntryRepository {
	
//	private List<DiaryEntry> entries = new ArrayList<DiaryEntry>();
	private File file = new File("entries.json");
	
	public void save(DiaryEntry entry) throws JsonParseException, JsonMappingException, IOException {
		List<DiaryEntry> entries = findAll();
		entries.add(entry);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(file, entries);
		
//		if(entries.stream().filter(e -> e.getId() == entry.getId()).count() > 0) {
//			throw new RuntimeException("The id " + entry.getId() + " already exists");
//		}
//		entries.add(entry);
	}
	
	public List<DiaryEntry> findAll() throws JsonParseException, JsonMappingException, IOException {
		if(!file.exists()) {
			return new ArrayList<>();
		}
		ObjectMapper objectMapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		List<DiaryEntry> entries = objectMapper.readValue(file, ArrayList.class);
		return entries;
	}
	
	public Optional<DiaryEntry> findById(int id) throws JsonParseException, JsonMappingException, IOException {
		return findAll().stream()
				.filter(e -> e.getId() == id)
				.findFirst();
	}

}
