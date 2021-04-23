package v1.model;

import java.time.LocalDate;

public class Child {
	
	private long id;
	private Image img;
	private String firstName;
	private LocalDate date;
	
	public Child() {
		
	}
	
	public Child(long id, Image img, String firstName, LocalDate date) {
		super();
		this.id = id;
		this.img = img;
		this.firstName = firstName;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
}
