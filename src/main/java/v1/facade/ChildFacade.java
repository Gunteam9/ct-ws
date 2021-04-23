package v1.facade;

import java.time.LocalDate;

import v1.exceptions.ChildNotFoundException;
import v1.model.Child;
import v1.model.Image;

public interface ChildFacade {
	
	public Child createChild(Image img, String firstName, LocalDate date);
	public Child getChild(long id) throws ChildNotFoundException;
	public void updateChild(long id, Child child) throws ChildNotFoundException;
}
