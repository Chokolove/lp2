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
import entidad.EntidadBean;
import entidad.TrabajadorBean;
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
				String sql = "Select e.*, c.nomCargo From empleado_servir e inner join cargo c on e.cargo_idCargo=c.idCargo where e.apePat like ? ;";
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
					bean.setDni(rs.getInt(5));
					bean.setSueldo(rs.getDouble(6));
					
					CargoBean entidad = new CargoBean();
					entidad.setIdCargo(rs.getInt(7));
					entidad.setNombre(rs.getString(8));
					
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
				String sql = "insert into empleado_servir values(null,?,?,?,?,?,?)";
				conn = new MysqlDBConexion().getConexion();
				pstm = conn.prepareStatement(sql);
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNombre());
				pstm.setString(2, obj.getApePat());
				pstm.setString(3, obj.getApeMat());
				pstm.setInt(4, obj.getDni());
				pstm.setDouble(5, obj.getSueldo());
				pstm.setInt(6, obj.getCargo().getIdCargo());
				
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
				String sql = "update expediente set Nombre =?, apePat =?, apeMat =?, Dni= ?, sueldo =?,  cargo_idCargo =?  where idEmpleado =? ";
				conn = new MysqlDBConexion().getConexion();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNombre());
				pstm.setString(2, obj.getApePat());
				pstm.setString(3, obj.getApeMat());
				pstm.setInt(4, obj.getDni());
				pstm.setDouble(5, obj.getSueldo());
				pstm.setInt(6, obj.getCargo().getIdCargo());
				pstm.setInt(7, obj.getIdEmpleado());
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
		public List<CargoBean> listaCargo() {
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			List<CargoBean> lista = new ArrayList<CargoBean>();
			try {
				String sql = "SELECT * FROM cargo;";
				conn = new MysqlDBConexion().getConexion();
				pstm = conn.prepareStatement(sql);
				log.info(pstm);
				rs = pstm.executeQuery();
				CargoBean bean = null;
				while(rs.next()){
					bean = new CargoBean();
					bean.setIdCargo(rs.getInt(1));
					bean.setNombre(rs.getString(2));
					
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

}
