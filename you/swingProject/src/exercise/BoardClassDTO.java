package exercise;

public class BoardClassDTO {
	
	private String title;
	private String content;
	private String num;
	
	
	
	String getTitle() {
		return title;
	}
	void setTitle(String title) {
		this.title = title;
	}
	String getContent() {
		return content;
	}
	void setContent(String content) {
		this.content = content;
	}
	String getNum() {
		return num;
	}
	void setNum(String num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "BoardClassDTO [title=" + title + ", content=" + content + ", num=" + num + "]";
	}
	
	
	

}
