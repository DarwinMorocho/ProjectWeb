package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.ServicioProducto;
import modelo.Producto;

/**
 * Servlet implementation class EliminarProductoCtrl
 */
@WebServlet("/EliminarProductoCtrl")
public class EliminarProductoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicioProducto servicioProducto= new ServicioProducto();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarProductoCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		Producto prod= new Producto();
		prod.setIdProducto(Integer.valueOf(id));
		servicioProducto.eliminar(prod);

		
		RequestDispatcher rd = 
				request.getServletContext().getRequestDispatcher(
						"/consultarproductos.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
