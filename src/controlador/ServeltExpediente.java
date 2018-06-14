package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExpedienteDAO;
import entidad.EntidadBean;
import entidad.ExpedienteBean;
import entidad.TrabajadorBean;
import fabrica.Fabrica;


/**
 * Servlet implementation class ServeltExpediente
 */
@WebServlet("/Expediente")
public class ServeltExpediente extends HttpServlet {
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
		ExpedienteDAO dao = fabrica.getExpedientesDAO();
		
		String filtro = request.getParameter("filtro");
		List<ExpedienteBean> lista = null;
		List<TrabajadorBean> lista2 = null;
		try {
			lista =  dao.consultaExpediente(filtro);
			lista2 = dao.listaTrabajador();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("Expedientes", lista);
		request.setAttribute("Trabajadores", lista2);
		request.getRequestDispatcher("/expedienteCRUD.jsp").forward(request, response);
	}	
	protected void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		ExpedienteDAO dao = fabrica.getExpedientesDAO();
		
		String idTrabjador = request.getParameter("idTrabjador");
		TrabajadorBean trabajador = new TrabajadorBean();
		trabajador.setIdTrabajador(Integer.parseInt(idTrabjador));
		String Estado = request.getParameter("Estado");
		String fchApertura= request.getParameter("fchApertura");
		
		List<ExpedienteBean> lista = null;
		try {
			ExpedienteBean obj = new ExpedienteBean(); 
			obj.setTrabajador(trabajador);
			obj.setEstado(Estado);
			obj.setFchaApertura(fchApertura);
			dao.insertaExpediente(obj);
			lista =  dao.consultaExpediente("");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("Expedientes", lista);
		request.getRequestDispatcher("/expedienteCRUD.jsp").forward(request, response);
		
		
	}	
	protected void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		ExpedienteDAO dao = fabrica.getExpedientesDAO();
		
		String id = request.getParameter("id");
		List<ExpedienteBean> lista = null;
		try {
			dao.eliminaExpediente(Integer.parseInt(id));
			lista =  dao.consultaExpediente("");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("Expedientes", lista);
		request.getRequestDispatcher("/expedienteCRUD.jsp").forward(request, response);
	}	
	protected void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		ExpedienteDAO dao = fabrica.getExpedientesDAO();
		
		String idExpediente = request.getParameter("id");
		String idTrabjador = request.getParameter("idTrabjador");
		TrabajadorBean trabajador = new TrabajadorBean();
		trabajador.setIdTrabajador(Integer.parseInt(idTrabjador));
		String Estado = request.getParameter("Estado");
		String fchApertura= request.getParameter("fchApertura");
		
		List<ExpedienteBean> lista = null;
		try {
			ExpedienteBean obj = new ExpedienteBean();
			obj.setIdExpediente(Integer.parseInt(idExpediente));
			obj.setTrabajador(trabajador);
			obj.setEstado(Estado);
			obj.setFchaApertura(fchApertura);
			dao.actualizaExpediente(obj);
			lista =  dao.consultaExpediente("");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("Expedientes", lista);
		request.getRequestDispatcher("/Expediente?metodo=lista&filtro=").forward(request, response);
		
		
	}	

}
