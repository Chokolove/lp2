package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import entidad.DocumentoBean;
import entidad.ExpedienteBean;
import entidad.TrabajadorBean;
import util.MysqlDBConexion;

public class MySqlDocumento implements DocumentoDAO {

	private static final Log log = LogFactory.getLog(MySqlDocumento.class);

	@Override
	public List<DocumentoBean> consultaDocumento(String filtro) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<DocumentoBean> lista = new ArrayList<DocumentoBean>();
		try {
			String sql = "SELECT * FROM documento D inner join expediente E on D.NroExpediente=E.NroExpediente inner join trabajador_estatal T on T.idTrabajador=E.idTrabajador where T.Nombre like ? ;";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filtro + "%");
			log.info(pstm);
			rs = pstm.executeQuery();
			DocumentoBean bean = null;
			while (rs.next()) {
				bean = new DocumentoBean();
				bean.setIdDocumento(rs.getInt(1));
				bean.setDescripcion(rs.getString(3));
				bean.setLink(rs.getString(4));

				ExpedienteBean exp = new ExpedienteBean();
				exp.setIdExpediente(rs.getInt(5));
				exp.setEstado(rs.getString(6));

				TrabajadorBean trab = new TrabajadorBean();
				trab.setNombre(rs.getString(10));
				trab.setApePat(rs.getString(11));
				trab.setApeMat(rs.getString(12));
				trab.setDni(rs.getInt(13));

				exp.setTrabajador(trab);
				bean.setExpediente(exp);

				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return lista;
	}

	@Override
	public List<ExpedienteBean> listaExpediente() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<ExpedienteBean> lista = new ArrayList<ExpedienteBean>();
		try {
			String sql = "SELECT * FROM expediente;";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			ExpedienteBean bean = null;
			while (rs.next()) {
				bean = new ExpedienteBean();
				bean.setIdExpediente(rs.getInt(1));
				bean.setEstado(rs.getString(3));
				bean.setFchaApertura(rs.getString(4));

				TrabajadorBean trab = new TrabajadorBean();
				trab.setIdTrabajador(rs.getInt(2));

				bean.setTrabajador(trab);

				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return lista;
	}

	@Override
	public int eliminaDocumento(int idDocumento) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from documento where idDoc =?";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idDocumento);

			log.info(pstm);

			salida = pstm.executeUpdate();

		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)
					pstm.close();
			} catch (SQLException e1) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return salida;
	}

	@Override
	public int insertaDocumento(DocumentoBean obj) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into documento values(null,?,?,?)";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getExpediente().getIdExpediente());
			pstm.setString(2, obj.getDescripcion());
			pstm.setString(3, obj.getLink());

			log.info(pstm);

			salida = pstm.executeUpdate();

		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)
					pstm.close();
			} catch (SQLException e1) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return salida;
	}

	@Override
	public int actualizaDocumento(DocumentoBean obj) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update documento set NroExpediente =?, descripcion =?, link =? where idDoc =? ";
			conn = new MysqlDBConexion().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getExpediente().getIdExpediente());
			pstm.setString(2, obj.getDescripcion());
			pstm.setString(3, obj.getLink());
			pstm.setInt(4, obj.getIdDocumento());
			log.info(pstm);

			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)
					pstm.close();
			} catch (SQLException e1) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return salida;
	}

}
