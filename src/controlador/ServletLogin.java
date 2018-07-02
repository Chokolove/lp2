package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing;

import dao.UsuarioDAO;
import entidad.UsuarioBean;
import fabrica.Fabrica;


@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String user = request.getParameter("loginuser");
		String clave = request.getParameter("loginpassword");

		UsuarioBean bean = new UsuarioBean();
		bean.setUsuario(user);
		bean.setContrasena(clave);
		
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		UsuarioDAO dao = fabrica.getUsuarioDAO();
		
		UsuarioBean obj = null;
		 try { 
			 obj = dao.login(bean);
			 if(obj == null) {
				 String mensaje = "El usuario no exite";
				 request.setAttribute("mensaje", mensaje);
				 request.getRequestDispatcher("/login.jsp").forward(request, response);	 
			 } else {
				 HttpSession session = request.getSession();
				 session.setAttribute("objUsuario", obj);
				 
				 request.getRequestDispatcher("index.jsp").forward(request, response);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}








