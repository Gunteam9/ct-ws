package v1.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import v1.model.Admin;
import v1.model.Nursery;

@Component("NurseryFacade")
public class NurseryFacadeImpl implements NurseryFacade {

	private Nursery nursery;
	
	public NurseryFacadeImpl() {
		List<Admin> admins = new ArrayList<Admin>();
		admins.add(new Admin("admin1", "admin1"));
		admins.add(new Admin("admin2", "admin2"));
		
		nursery = new Nursery(admins, "random adresse");
	}
	
	@Override
	public Nursery getNursery() {
		return nursery;
	}

}
