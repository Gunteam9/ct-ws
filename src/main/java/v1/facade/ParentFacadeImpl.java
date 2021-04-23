package v1.facade;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import v1.model.Child;
import v1.model.Parent;

@Component("UserFacade")
public class ParentFacadeImpl implements ParentFacade {

	private final Map<String, Parent> parents = new HashMap<String, Parent>();
	
	@Override
	public Parent register(String username, String password, Child child) {
		Parent parent = new Parent(username, password, child);
		parents.put(username, parent);
		
		return parent;
	}
	
	@Override
	public Collection<Parent> getParents() {
		return parents.values();
	}
	
	@Override
	public Parent getParent(String username) {
		return parents.get(username);
	}

}
