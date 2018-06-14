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
import util.MysqlDBConexion;

public class MySqlExpediente implements ExpedienteDAO{
	
	private static final Log log = LogFactory.getLog(MySqlExpediente.class);

	@Override
	public List<ExpedienteBean> consultaExpediente(String filtro) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<ExpedienteBean> lista = new ArrayList<ExpedienteBean>();
		try {
			String sql = "SELECT * FROM expediente ex inner join trabajador_estatal tr on ex.idTrabajador=tr.idTrabajador inner join entidad_estatal ent on tr.entidad_estatal_idEntidad=ent.idEntidad where ent.nombre like ? ;";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro + "%");
			log.info(pstm);
			rs = pstm.executeQuery();
			ExpedienteBean bean = null;
			while(rs.next()){
				bean = new ExpedienteBean();
				bean.setIdExpediente(rs.getInt(1));
				
				TrabajadorBean trabajador = new TrabajadorBean();
				trabajador.setIdTrabajador(rs.getInt(2));
				trabajador.setNombre(rs.getString(6));
				trabajador.setApePat(rs.getString(7));
				trabajador.setApeMat(rs.getString(8));
				trabajador.setDni(rs.getInt(9));
				
				EntidadBean entidad = new EntidadBean();
				entidad.setIdEntidad(rs.getInt(11));
				entidad.setPoderEst(rs.getString(12));
				entidad.setSector(rs.getString(13));
				entidad.setRuc(rs.getInt(14));
				entidad.setNombre(rs.getString(15));
				entidad.setDireccion(rs.getString(16));
				
				trabajador.setEntidad(entidad);
				bean.setTrabajador(trabajador);
				
				bean.setEstado(rs.getString(3));
				bean.setFchaApertura(rs.getString(4));
				
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
	public List<TrabajadorBean> listaTrabajador() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<TrabajadorBean> lista = new ArrayList<TrabajadorBean>();
		try {
			String sql = "SELECT * FROM trabajador_estatal;";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			TrabajadorBean bean = null;
			while(rs.next()){
				bean = new TrabajadorBean();
				bean.setIdTrabajador(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setApePat(rs.getString(3));
				bean.setApeMat(rs.getString(4));
				bean.setDni(rs.getInt(5));
				
				EntidadBean entidad = new EntidadBean();
				entidad.setIdEntidad(rs.getInt(6));
				
				bean.setEntidad(entidad);
				
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
	public int eliminaExpediente(int idExpediente) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from expediente where NroExpediente =?";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idExpediente);

			log.info(pstm);
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	@Override
	public int insertaExpediente(ExpedienteBean obj) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into expediente values(null,?,?,?)";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getTrabajador().getIdTrabajador());
			pstm.setString(2, obj.getEstado());
			pstm.setString(3, obj.getFchaApertura());
			
			log.info(pstm);
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	@Override
	public int actualizaExpediente(ExpedienteBean obj) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update expediente set idTrabajador =?, Estado =?, fchApertura =? where NroExpediente =? ";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getTrabajador().getIdTrabajador());
			pstm.setString(2, obj.getEstado());
			pstm.setString(3, obj.getFchaApertura());
			pstm.setInt(4, obj.getIdExpediente());
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	

}
