package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpleadoDAO;
import entidad.CargoBean;
import entidad.EmpleadoBean;
import fabrica.Fabrica;


/**
 * Servlet implementation class ServeltExpediente
 */
@WebServlet("/Empleado")
public class ServeltEmpleado extends HttpServlet {
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
		EmpleadoDAO dao = fabrica.getEmpleadoDAO();
		
		String filtro = request.getParameter("filtro");
		List<EmpleadoBean> lista = null;
		try {
			lista =  dao.consultaEmpleadoPorCargo(filtro);
			lista = dao.listaEmpleado();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("Empleado", lista);
		request.getRequestDispatcher("/empleadoCRUD.jsp").forward(request, response);
	}	
	protected void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		EmpleadoDAO dao = fabrica.getEmpleadoDAO();
		
		String nombre = request.getParameter("nombre");
		String apePat= request.getParameter("apePat");
		String apeMat= request.getParameter("apeMat");
		String sueldo= request.getParameter("sueldo");
		String idCargo = request.getParameter("idCargo");
		CargoBean cargo = new CargoBean();
		cargo.setIdCargo(Integer.parseInt(idCargo));
		
		List<EmpleadoBean> lista = null;
		try {
			EmpleadoBean obj = new EmpleadoBean(); 
			obj.setNombre(nombre);
			obj.setApePat(apePat);
			obj.setApeMat(apeMat);
			obj.setSueldo(Double.parseDouble(sueldo));
			obj.setCargo(cargo);
			
			dao.insertaEmpleado(obj);
			lista =  dao.consultaEmpleadoPorCargo("");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("Empleado", lista);
		request.getRequestDispatcher("//Empleado?metodo=lista&filtro=").forward(request, response);
		
		
	}	
	protected void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		EmpleadoDAO dao = fabrica.getEmpleadoDAO();
		
		String id = request.getParameter("id");
		List<EmpleadoBean> lista = null;
		try {
			dao.eliminaEmpleado(Integer.parseInt(id));
			lista =  dao.consultaEmpleadoPorCargo("");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("Empleado", lista);
		request.getRequestDispatcher("//Empleado?metodo=lista&filtro=").forward(request, response);
	}	
	protected void actualiza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		EmpleadoDAO dao = fabrica.getEmpleadoDAO();
		
		String idEmpleado = request.getParameter("idEmpleado");
		String nombre = request.getParameter("nombre");
		String apePat= request.getParameter("apePat");
		String apeMat = request.getParameter("apeMat");
		String sueldo = request.getParameter("sueldo");
		
		String idCargo = request.getParameter("idCargo");
		CargoBean cargo = new CargoBean();
		cargo.setIdCargo(Integer.parseInt(idCargo));
		
		List<EmpleadoBean> lista = null;
		try {
			EmpleadoBean obj = new EmpleadoBean();
			obj.setIdEmpleado(Integer.parseInt(idEmpleado));
			obj.setNombre(nombre);
			obj.setApePat(apePat);
			obj.setApeMat(apeMat);
			obj.setSueldo(Double.parseDouble(sueldo));
			obj.setCargo(cargo);
			dao.actualizaEmpleado(obj);
			lista =  dao.consultaEmpleadoPorCargo("");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("Empleado", lista);
		request.getRequestDispatcher("/Empleado?metodo=lista&filtro=").forward(request, response);
		
		
	}	

}
