package v1.facade;

import v1.model.Admin;
import v1.model.Nursery;

public interface NurseryFacade {
	
	public Nursery getNursery();
	public Admin getAdmin(String username);
}
