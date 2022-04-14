package uo.ri.cws.application.ui.manager.action;


import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.mechanic.crud.MechanicCrudServiceImpl;

public class DeleteMechanicAction implements Action {

	

	@Override
	public void execute() throws BusinessException {
		String idMechanic = Console.readString("Type mechanic id "); 
		MechanicDto mdto = new MechanicDto();
		mdto.id=idMechanic;
		MechanicCrudServiceImpl mcsi = new MechanicCrudServiceImpl();
		mcsi.deleteMechanic(idMechanic);
		Console.println("Mechanic deleted");
	}

}