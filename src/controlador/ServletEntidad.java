package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EntidadDAO;
import dao.DocumentoDAO;
import dao.ExpedienteDAO;
import entidad.DocumentoBean;
import entidad.EmpleadoBean;
import entidad.EntidadBean;
import entidad.ExpedienteBean;
import entidad.TrabajadorBean;
import fabrica.Fabrica;


/**
 * Servlet implementation class ServeltDocumento
 */
@WebServlet("/Entidad")
public class ServletEntidad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		if(metodo.equals("lista")){
			lista(request, response);
		}else if(metodo.equals("registra")){
			registra(request, response);
		}else if(metodo.equals("elimina")){
			elimina(request, response);
		}else if(metodo.equals("actualiza")){
			actualiza(request, response);
		}
	}
	protected void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		EntidadDAO dao = fabrica.getEntidadDAO();
		
		String filtro = request.getParameter("filtro");
		List<EntidadBean> lista = null;
		try {
			lista =  dao.listaEntidad();
			lista =  dao.consultaEntidadPorNombre(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("Entidad", lista);
		request.getRequestDispatcher("/entidadCRUD.jsp").forward(request, response);
	}	
	protected void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		EntidadDAO dao = fabrica.getEntidadDAO();
		
		String pString = request.getParameter("Poder");
		String secString= request.getParameter("Sector");
		String rucString= request.getParameter("Ruc");
		String nomString= request.getParameter("Nombre");
		String direString= request.getParameter("Direccion");
		
		List<EntidadBean> lista = null;
		try {
			EntidadBean obj = new EntidadBean(); 
			obj.setPoderEst(pString);
			obj.setSector(secString);
			obj.setRuc(Integer.parseInt(rucString));
			obj.setNombre(nomString);
			obj.setDireccion(direString);
			
			dao.insertaEntidad(obj);
			lista =  dao.consultaEntidadPorNombre("");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("Entidad", lista);
		request.getRequestDispatcher("/entidadCRUD.jsp").forward(request, response);	
	}	
	protected void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		EntidadDAO dao = fabrica.getEntidadDAO();
		
		String id = request.getParameter("id");
		List<EntidadBean> lista = null;
		try {
			dao.eliminaEntidad(Integer.parseInt(id));
			lista =  dao.consultaEntidadPorNombre("");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("Entidad", lista);
		request.getRequestDispatcher("/entidadCRUD.jsp").forward(request, response);	
	}	
	protected void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		EntidadDAO dao = fabrica.getEntidadDAO();
		
		String idEntidad = request.getParameter("idEntidad");
		EntidadBean entidad = new EntidadBean();
		entidad.setIdEntidad(Integer.parseInt(idEntidad));
		String pString = request.getParameter("Poder");
		String secString= request.getParameter("Sector");
		String rucString= request.getParameter("Ruc");
		String nomString= request.getParameter("Nombre");
		String direString= request.getParameter("Direccion");
		
		List<EntidadBean> lista = null;
		try {
			EntidadBean obj = new EntidadBean();
			obj.setIdEntidad(Integer.parseInt(idEntidad));
			obj.setPoderEst(pString);
			obj.setSector(secString);
			obj.setRuc(Integer.parseInt(rucString));
			obj.setNombre(nomString);
			obj.setDireccion(direString);
			dao.actualizaEntidad(obj);
			lista =  dao.consultaEntidadPorNombre("");
		} catch (Exception e) {
			e.printStackTrace();
		request.setAttribute("Entidad", lista);
		request.getRequestDispatcher("/entidadCRUD.jsp").forward(request, response);
	}	

}
}
