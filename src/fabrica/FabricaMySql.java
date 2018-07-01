package fabrica;

import dao.AmpliacionesDAO;
import dao.DocumentoDAO;
import dao.EmpleadoDAO;
import dao.EntidadDAO;
import dao.ExpedienteDAO;
import dao.MySqlAmpliacion;
import dao.MySqlDocumento;
import dao.MySqlEntidad;
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

	public DocumentoDAO getDocumentosDAO() {
		// TODO Auto-generated method stub
		return new MySqlDocumento();
	}
	public EmpleadoDAO getEmpleadoDAO() {
		// TODO Auto-generated method stub
		return new MySqlEmpleado();

	}

	@Override
	public EntidadDAO getEntidadDAO() {
		// TODO Auto-generated method stub
		return new MySqlEntidad();
	}



	
}
