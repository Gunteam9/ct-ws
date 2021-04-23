package v1.facade;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import v1.exceptions.ChildNotFoundException;
import v1.model.Child;
import v1.model.Image;
import v1.model.Parent;

@Component("ChildFacade")
public class ChildFacadeImpl implements ChildFacade {
	
	private Map<Long, Child> childrens = new HashMap<Long, Child>();
	private final AtomicLong idCounter = new AtomicLong(1L);
	
	
	@Autowired
	ParentFacade parentFacade;
	
	public ChildFacadeImpl() {

	}
	
	@Override
	public Child createChild(Image img, String firstName, LocalDate date) {
		Child child = new Child(idCounter.getAndIncrement(), img, firstName, date);
		childrens.put(idCounter.get() - 1, child);
		
		return child;
	}
	
	@Override
	public Child getChild(long id) throws ChildNotFoundException {
		return childrens.get(id);
	}
	
	@Override
	public void updateChild(long id, Child child) throws ChildNotFoundException {
		child.setId(id);
		childrens.replace(id, child);
		
//		System.out.println(id);
//		System.out.println(childrens.get(id).getFirstName());
		
		for (Parent p : parentFacade.getParents()) {
			if (p.getChild().getId() == id)
				p.setChild(child);
		}
	}

}
