package v1.facade;

import java.util.Collection;

import v1.model.Child;
import v1.model.Parent;

public interface ParentFacade {
	public Parent register(String username, String password, Child child);
	public Collection<Parent> getParents();
	public Parent getParent(String username);
}
