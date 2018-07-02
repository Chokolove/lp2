package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entidad.EntidadBean;
import entidad.ExpedienteBean;
import entidad.TrabajadorBean;
import entidad.TramiteBean;
import util.MysqlDBConexion;

public class MySqlTramite implements TramiteDAO {
	
	private static final Log log = LogFactory.getLog(MySqlExpediente.class);

	@Override
	public List<TramiteBean> consultaTramite(String filtro) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<TramiteBean> lista = new ArrayList<TramiteBean>();
		try {
			String sql = "SELECT * FROM tramite t join expediente e on t.NroExpediente=e.NroExpediente join trabajador_estatal tr on e.idTrabajador=tr.idTrabajador where t.idTramite = ? ;";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro);
			log.info(pstm);
			rs = pstm.executeQuery();
			TramiteBean bean = null;
			while(rs.next()){
				bean = new TramiteBean();
				bean.setIdTramite(rs.getInt(1));
				bean.setFchVenc(rs.getString(3));
				bean.setEstado(rs.getString(4));
				bean.setTipo(rs.getString(5));
				
				ExpedienteBean expe = new ExpedienteBean();
				expe.setIdExpediente(rs.getInt(2));
				
				TrabajadorBean trabajador = new TrabajadorBean();
				trabajador.setIdTrabajador(rs.getInt(10));
				trabajador.setNombre(rs.getString(11));
				trabajador.setApePat(rs.getString(12));
				trabajador.setApeMat(rs.getString(13));
				trabajador.setDni(rs.getInt(14));
				
				EntidadBean entidad = new EntidadBean();
				entidad.setIdEntidad(rs.getInt(15));
				
				trabajador.setEntidad(entidad);
				expe.setTrabajador(trabajador);
				
				expe.setEstado(rs.getString(8));
				expe.setFchaApertura(rs.getString(9));
				
				bean.setExpediente(expe);
				
				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}

	@Override
	public int insertaTramite(TramiteBean obj) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizaTramite(TramiteBean obj) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
