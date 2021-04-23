package v1.facade;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import v1.exceptions.ChildNotFoundException;
import v1.model.Child;
import v1.model.Parent;

@Component("ChildFacade")
public class ChildFacadeImpl implements ChildFacade {
	
	@Autowired
	ParentFacade parentFacade;
	
	@Override
	public Child getChild(long id) throws ChildNotFoundException {
		Child child = parentFacade.getParents().stream().filter(o -> o.getChild().getId() == id).collect(Collectors.toList()).get(0).getChild();
		return child;
	}
	
	@Override
	public void updateChild(Child child) throws ChildNotFoundException {
		for (Parent p : parentFacade.getParents()) {
			if (p.getChild().getId() == child.getId())
				p.setChild(child);
		}
	}

}
