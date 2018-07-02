package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entidad.CargoBean;
import entidad.EmpleadoBean;
import entidad.UsuarioBean;
import util.MysqlDBConexion;

public class MySqlUsuario implements UsuarioDAO{
	
	private static final Log log = LogFactory.getLog(MySqlEmpleado.class);
	@Override
	public UsuarioBean login(UsuarioBean bean) throws Exception {
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		UsuarioBean obj = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql ="SELECT * FROM usuario u join empleado_servir e on u.empleado_idEmpleado=e.idEmpleado where usuario = ? and contrasena = ?;";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bean.getUsuario());
			pstm.setString(2, bean.getContrasena());
			
			log.info(pstm);
			
			rs = pstm.executeQuery();
			while(rs.next()){
				obj = new UsuarioBean();
				obj.setUsuario(rs.getString(1));
				obj.setContrasena(rs.getString(2));
				EmpleadoBean emple = new EmpleadoBean();
				emple.setIdEmpleado(rs.getInt(4));
				emple.setNombre(rs.getString(5));
				emple.setApePat(rs.getString(6));
				emple.setApeMat(rs.getString(7));
				emple.setDni(rs.getInt(8));
				emple.setSueldo(rs.getDouble(9));
				
				CargoBean entidad = new CargoBean();
				entidad.setIdCargo(rs.getInt(10));
				
				emple.setCargo(entidad);
				obj.setEmpleado(emple);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		return obj;
	}

}
