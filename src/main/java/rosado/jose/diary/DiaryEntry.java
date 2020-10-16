package rosado.jose.diary;

import java.time.LocalDateTime;

public class DiaryEntry {

	private int id;
	
	private String text;
	
	private LocalDateTime createDate;
	
	public DiaryEntry() {}
	
	public DiaryEntry(int id, String text, LocalDateTime dt) {
		this.setId(id);
		this.setText(text);
		this.setCreateDate(dt);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
}
