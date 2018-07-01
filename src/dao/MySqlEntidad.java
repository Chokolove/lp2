package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entidad.AmpliacionesBean;
import entidad.CargoBean;
import entidad.EmpleadoBean;
import entidad.EntidadBean;
import util.MysqlDBConexion;

public class MySqlEntidad implements EntidadDAO{

	private static final Log log = LogFactory.getLog(MySqlEntidad.class);
	
	public int insertaEntidad(EntidadBean obj) throws Exception{
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into entidad values(null,?,?,?,?,?,?)";
			new MysqlDBConexion();
			conn = MysqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdEntidad());
			pstm.setString(2, obj.getPoderEst());
			pstm.setString(3, obj.getSector());
			pstm.setInt(4, obj.getRuc());
			pstm.setString(5, obj.getNombre());
			pstm.setString(6, obj.getDireccion());
			
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
	public List<EntidadBean> consultaEntidadPorNombre(String filtro) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<EntidadBean> lista = new ArrayList<EntidadBean>();
		
		try {
			String sql = "SELECT * FROM entidad where nombre like ? ;";
			new MysqlDBConexion();
			conn = MysqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro + "%");
			log.info(pstm);
			rs = pstm.executeQuery();
			EntidadBean bean = null;
			while(rs.next()){
				bean = new EntidadBean();
				bean.setIdEntidad(rs.getInt(1));
				bean.setPoderEst(rs.getString(2));
				bean.setSector(rs.getString(3));
				bean.setRuc(rs.getInt(4));
				bean.setNombre(rs.getString(5));
				bean.setDireccion(rs.getString(6));
				
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
		return (ArrayList<EntidadBean>) lista;
	}
	public int eliminaEntidad(int idEnt) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from entidad where idEnt =?";
			new MysqlDBConexion();
			conn = MysqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idEnt);

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
	public int actualizaEntidad(EntidadBean obj) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update entidad set IdEntidad =?, poder_est =?, sector =?, ruc=?, nombre=?, direccion=?";
			new MysqlDBConexion();
			conn = MysqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdEntidad());
			pstm.setString(2, obj.getPoderEst());
			pstm.setString(3, obj.getSector());
			pstm.setInt(4, obj.getRuc());
			pstm.setString(5, obj.getNombre());
			pstm.setString(6, obj.getDireccion());
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
	
	public List<EntidadBean> listaEntidad() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<EntidadBean> lista = new ArrayList<EntidadBean>();
		try {
			String sql = "SELECT * FROM entidad;";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			EntidadBean bean = null;
			while(rs.next()){
				bean = new EntidadBean();
				bean.setIdEntidad(rs.getInt(1));
				bean.setPoderEst(rs.getString(2));
				bean.setSector(rs.getString(3));
				bean.setRuc(rs.getInt(4));
				bean.setNombre(rs.getString(5));
				bean.setDireccion(rs.getString(6));
				
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

	public ArrayList listaExpediente() {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertaAmpliacion(AmpliacionesBean ampliacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList consultaAmpliacion() {
		// TODO Auto-generated method stub
		return null;
	}

}



