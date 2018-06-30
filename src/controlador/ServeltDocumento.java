package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DocumentoDAO;
import entidad.DocumentoBean;
import entidad.ExpedienteBean;
import fabrica.Fabrica;

/**
 * Servlet implementation class ServeltDocumento
 */
@WebServlet("/Documento")
public class ServeltDocumento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		if (metodo.equals("lista")) {
			lista(request, response);
		} else if (metodo.equals("registra")) {
			registra(request, response);
		} else if (metodo.equals("elimina")) {
			elimina(request, response);
		} else if (metodo.equals("actualiza")) {
			actualiza(request, response);
		}
	}

	protected void lista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		DocumentoDAO dao = fabrica.getDocumentosDAO();

		String filtro = request.getParameter("filtro");
		List<DocumentoBean> lista = null;
		List<ExpedienteBean> lista2 = null;
		try {
			lista = dao.consultaDocumento(filtro);
			lista2 = dao.listaExpediente();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("Documentos", lista);
		request.setAttribute("Expedientes", lista2);
		request.getRequestDispatcher("/documentoCRUD.jsp").forward(request, response);
	}

	protected void registra(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		DocumentoDAO dao = fabrica.getDocumentosDAO();

		String idExp = request.getParameter("idExpediente");
		ExpedienteBean exp = new ExpedienteBean();
		exp.setIdExpediente(Integer.parseInt(idExp));
		String descripcion = request.getParameter("Descripcion");
		String link = request.getParameter("Link");

		List<DocumentoBean> lista = null;
		try {
			DocumentoBean obj = new DocumentoBean();
			obj.setExpediente(exp);
			obj.setDescripcion(descripcion);
			obj.setLink(link);
			dao.insertaDocumento(obj);
			lista = dao.consultaDocumento("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("Documentos", lista);
		request.getRequestDispatcher("//Documento?metodo=lista&filtro=").forward(request, response);

	}

	protected void elimina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		DocumentoDAO dao = fabrica.getDocumentosDAO();

		String id = request.getParameter("id");
		List<DocumentoBean> lista = null;
		try {
			dao.eliminaDocumento(Integer.parseInt(id));
			lista = dao.consultaDocumento("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("Documentos", lista);
		request.getRequestDispatcher("//Documento?metodo=lista&filtro=").forward(request, response);
	}

	protected void actualiza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
		DocumentoDAO dao = fabrica.getDocumentosDAO();

		String idDoc = request.getParameter("id");
		String idExp = request.getParameter("idExpediente");
		ExpedienteBean exp = new ExpedienteBean();
		exp.setIdExpediente(Integer.parseInt(idExp));
		String descripcion = request.getParameter("Descripcion");
		String link = request.getParameter("Link");

		List<DocumentoBean> lista = null;
		try {
			DocumentoBean obj = new DocumentoBean();
			obj.setIdDocumento(Integer.parseInt(idDoc));
			obj.setExpediente(exp);
			obj.setDescripcion(descripcion);
			obj.setLink(link);
			dao.actualizaDocumento(obj);
			lista = dao.consultaDocumento("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("Documentos", lista);
		request.getRequestDispatcher("/Documento?metodo=lista&filtro=").forward(request, response);

	}

}
