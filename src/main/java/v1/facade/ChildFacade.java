package v1.facade;

import v1.exceptions.ChildNotFoundException;
import v1.model.Child;

public interface ChildFacade {
	public Child getChild(long id) throws ChildNotFoundException;
	public void updateChild(Child child) throws ChildNotFoundException;
}
