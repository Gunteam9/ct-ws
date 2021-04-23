package v1.model;

public class Parent {
	
	private String username;
	private String password;
	private Child child;
	
	public Parent() {
		super();
	}
	
	public Parent(String username, String password, Child child) {
		super();
		this.username = username;
		this.password = password;
		this.child = child;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
	
	
	
}
