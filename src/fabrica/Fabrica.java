package fabrica;

import dao.AmpliacionesDAO;
import dao.EmpleadoDAO;
import dao.ExpedienteDAO;

public abstract class  Fabrica {

	public static final int MYSQL =1;
	public static final int SQLSERVER =2;

	
	public abstract AmpliacionesDAO getAmpliacionesDao();
	public abstract ExpedienteDAO getExpedientesDAO();
	public abstract EmpleadoDAO getEmpleadoDAO();
	public static Fabrica getFabrica(int tipo){
		switch (tipo) {
		case MYSQL:
			return new FabricaMySql();
		case SQLSERVER:
			return null;
		}
		return null;
	}
	
	
}
