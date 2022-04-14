package uo.ri.cws.application.ui.manager.action;



import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.mechanic.crud.MechanicCrudServiceImpl;

public class FindAllMechanicsAction implements Action {

	
	
	@Override
	public void execute() throws BusinessException {

		Console.println("\nList of mechanics \n");  

		MechanicCrudServiceImpl mcsi = new MechanicCrudServiceImpl();
		mcsi.findAllMechanics();
		
	}
}