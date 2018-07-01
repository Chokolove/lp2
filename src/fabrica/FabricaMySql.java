package fabrica;

import dao.AmpliacionesDAO;
import dao.DocumentoDAO;
import dao.ExpedienteDAO;
import dao.MySqlAmpliacion;
import dao.MySqlDocumento;
import dao.MySqlExpediente;

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



	
}
