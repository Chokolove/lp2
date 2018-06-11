package fabrica;

import dao.AmpliacionesDAO;
import dao.MySqlAmpliacion;

public class FabricaMySql extends Fabrica {

	@Override
	public AmpliacionesDAO getAmpliacionesDao() {
		
		return new MySqlAmpliacion();
	}



	
}
