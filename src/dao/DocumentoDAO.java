package dao;

import java.util.List;

import entidad.DocumentoBean;
import entidad.ExpedienteBean;

public interface DocumentoDAO {

	public abstract List<DocumentoBean> consultaDocumento(String filtro) throws Exception;

	public abstract List<ExpedienteBean> listaExpediente();

	public abstract int eliminaDocumento(int idDocumento) throws Exception;

	public abstract int insertaDocumento(DocumentoBean obj) throws Exception;

	public abstract int actualizaDocumento(DocumentoBean obj) throws Exception;

}
