package fabrica;

import dao.DocumentoDAO;
import dao.EmpleadoDAO;
import dao.EntidadDAO;
import dao.ExpedienteDAO;
import dao.MySqlDocumento;
import dao.MySqlEntidad;
import dao.MySqlExpediente;
import dao.MySqlTramite;
import dao.MySqlUsuario;
import dao.TramiteDAO;
import dao.UsuarioDAO;
import dao.MySqlEmpleado;

public class FabricaMySql extends Fabrica {

	

	@Override
	public ExpedienteDAO getExpedientesDAO() {
		// TODO Auto-generated method stub
		return new MySqlExpediente();
	}
	@Override
	public TramiteDAO getTramiteDAO() {
		// TODO Auto-generated method stub
		return new MySqlTramite();
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

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuario();
	}



	
}
