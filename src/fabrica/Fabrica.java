package fabrica;

import dao.DocumentoDAO;
import dao.EmpleadoDAO;
import dao.EntidadDAO;
import dao.ExpedienteDAO;
import dao.TramiteDAO;
import dao.UsuarioDAO;

public abstract class  Fabrica {

	public static final int MYSQL =1;
	public static final int SQLSERVER =2;

	
	public abstract ExpedienteDAO getExpedientesDAO();

	public abstract DocumentoDAO getDocumentosDAO();

	public abstract TramiteDAO getTramiteDAO();
	public abstract EmpleadoDAO getEmpleadoDAO();
	public abstract EntidadDAO getEntidadDAO();
	public abstract UsuarioDAO getUsuarioDAO();

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
