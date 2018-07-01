package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entidad.CargoBean;
import entidad.EmpleadoBean;
import util.MysqlDBConexion;

public class MySqlEmpleado implements EmpleadoDAO{
	
	private static final Log log = LogFactory.getLog(MySqlEmpleado.class);

		@Override
		public List<EmpleadoBean> consultaEmpleadoPorCargo(String filtro) throws Exception {
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			List<EmpleadoBean> lista = new ArrayList<EmpleadoBean>();
			try {
				String sql = "Select e.*, c.nombre From empleado_servir e inner join cargo c on e.cargo_idCargo=c.idCargo";
				conn = new MysqlDBConexion().getConexion();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, filtro + "%");
				log.info(pstm);
				rs = pstm.executeQuery();
				EmpleadoBean bean = null;
				while(rs.next()){
					bean = new EmpleadoBean();
					bean.setIdEmpleado(rs.getInt(1));
					bean.setNombre(rs.getString(2));
					bean.setApePat(rs.getString(3));
					bean.setApeMat(rs.getString(4));
					bean.setSueldo(rs.getDouble(5));
					
					CargoBean entidad = new CargoBean();
					entidad.setIdCargo(rs.getInt(6));
					entidad.setNombre(rs.getString(7));
					
					bean.setCargo(entidad);
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
		public List<EmpleadoBean> listaEmpleado() {
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			List<EmpleadoBean> lista = new ArrayList<EmpleadoBean>();
			try {
				String sql = "SELECT * FROM empleado_servir;";
				conn = new MysqlDBConexion().getConexion();
				pstm = conn.prepareStatement(sql);
				log.info(pstm);
				rs = pstm.executeQuery();
				EmpleadoBean bean = null;
				while(rs.next()){
					bean = new EmpleadoBean();
					bean.setIdEmpleado(rs.getInt(1));
					bean.setNombre(rs.getString(2));
					bean.setApePat(rs.getString(3));
					bean.setApeMat(rs.getString(4));
					bean.setSueldo(rs.getDouble(5));
					
					
					CargoBean entidad = new CargoBean();
					entidad.setIdCargo(rs.getInt(6));
					entidad.setNombre(rs.getString(7));
					
					bean.setCargo(entidad);
					
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
		public int eliminaEmpleado(int idEmpleado) throws Exception {
			Connection conn = null;
			PreparedStatement pstm = null;
			int salida = -1;
			try {
				String sql = "delete from empleado_servir where idEmpleado =?";
				conn = new MysqlDBConexion().getConexion();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, idEmpleado);

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
		public int insertaEmpleado(EmpleadoBean obj) throws Exception {
			Connection conn = null;
			PreparedStatement pstm = null;
			int salida = -1;
			try {
				String sql = "insert into empleado_servir values(null,?,?,?,?,?)";
				conn = new MysqlDBConexion().getConexion();
				pstm = conn.prepareStatement(sql);
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNombre());
				pstm.setString(2, obj.getApePat());
				pstm.setString(3, obj.getApeMat());
				pstm.setDouble(4, obj.getSueldo());
				pstm.setInt(5, obj.getCargo().getIdCargo());
				
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
		public int actualizaEmpleado(EmpleadoBean obj) throws Exception {
			Connection conn = null;
			PreparedStatement pstm = null;
			int salida = -1;
			try {
				String sql = "update expediente set nombre =?, apePat =?, apeMat =?, sueldo =?, cargo =?  where idEmpleado =? ";
				conn = new MysqlDBConexion().getConexion();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNombre());
				pstm.setString(2, obj.getApePat());
				pstm.setString(3, obj.getApeMat());
				pstm.setDouble(4, obj.getSueldo());
				pstm.setInt(5, obj.getCargo().getIdCargo());
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
