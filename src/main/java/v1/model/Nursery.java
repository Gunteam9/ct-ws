package v1.model;

import java.util.ArrayList;
import java.util.List;

public class Nursery {
	
	private List<Admin> admins = new ArrayList<Admin>();
	private String adresse;
	
	public Nursery() {
		super();
	}

	public Nursery(List<Admin> admins, String adresse) {
		super();
		this.admins = admins;
		this.adresse = adresse;
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
