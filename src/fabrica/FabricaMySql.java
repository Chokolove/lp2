package fabrica;

import dao.AmpliacionesDAO;
import dao.EmpleadoDAO;
import dao.ExpedienteDAO;
import dao.MySqlAmpliacion;
import dao.MySqlExpediente;
import dao.MySqlEmpleado;

public class FabricaMySql extends Fabrica {

	@Override
	public AmpliacionesDAO getAmpliacionesDao() {
		
		return new MySqlAmpliacion();
	}

	@Override
	public ExpedienteDAO getExpedientesDAO() {
		// TODO Auto-generated method stub
		return new MySqlExpediente();
	}

	@Override
	public EmpleadoDAO getEmpleadoDAO() {
		// TODO Auto-generated method stub
		return new MySqlEmpleado();
	}



	
}
