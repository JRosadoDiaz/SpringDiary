package rosado.jose.diary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiaryConfiguration {

	// Dependency Injection
	@Bean
	public DiaryEntryRepository diaryEntryRepository() {
		return new DiaryEntryRepository();
	}
}
