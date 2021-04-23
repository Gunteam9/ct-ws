package v1.model;

public class Parent {
	
	private String login;
	private String password;
	private Child child;
	
	public Parent() {
		super();
	}
	
	public Parent(String login, String password, Child child) {
		super();
		this.login = login;
		this.password = password;
		this.child = child;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
