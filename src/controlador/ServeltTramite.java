package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExpedienteDAO;
import dao.TramiteDAO;
import entidad.EntidadBean;
import entidad.ExpedienteBean;
import entidad.TrabajadorBean;
import entidad.TramiteBean;
import fabrica.Fabrica;


/**
 * Servlet implementation class ServeltExpediente
 */
@WebServlet("/Tramite")
public class ServeltTramite extends HttpServlet {
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
		}else if(metodo.equals("actualiza")){
			actualiza(request, response);
		}
	}
	protected void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		TramiteDAO dao = fabrica.getTramiteDAO();
		
		String filtro = request.getParameter("id");
		List<TramiteBean> lista = null;
		try {
			lista =  dao.consultaTramite(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("a", lista);
		request.getRequestDispatcher("/tramiteAmpliacion.jsp").forward(request, response);
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
		request.getRequestDispatcher("//Expediente?metodo=lista&filtro=").forward(request, response);
		
		
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
