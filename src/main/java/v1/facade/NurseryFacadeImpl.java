package v1.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import v1.model.Admin;
import v1.model.Nursery;

@Component("NurseryFacade")
public class NurseryFacadeImpl implements NurseryFacade {

	private Nursery nursery;
	
	private Map<String, Admin> admins = new HashMap<String, Admin>();
	
	public NurseryFacadeImpl() {
		admins.put("admin1", new Admin("admin1", "admin1"));
		admins.put("admin2", new Admin("admin2", "admin2"));
		
		nursery = new Nursery(new ArrayList<Admin>(admins.values()), "random adresse");
	}
	
	@Override
	public Nursery getNursery() {
		return nursery;
	}
	
	@Override
	public Admin getAdmin(String username) {
		return admins.get(username);
	}

}
