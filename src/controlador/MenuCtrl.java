package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.ServicioCliente;
import servicios.ServicioProducto;
import modelo.Cliente;
import modelo.Producto;

/**
 * Servlet implementation class MenuCtrl
 */
@WebServlet("/MenuCtrl")
public class MenuCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicioProducto servicioProducto = new ServicioProducto();
	ServicioCliente servicioCliente= new ServicioCliente();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuCtrl() {
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
		

		String prod = request.getParameter("par");
		System.out.println("entra al serlevt  menu "+prod);
		if (prod.equals("producto")) {

			List<Producto> listaProd = servicioProducto.findByProdNombre("");
			request.setAttribute("PRODUCTO", listaProd);
			// redireccionar a la vista
			System.out.print("1");
			RequestDispatcher rd = request.getServletContext()
					.getRequestDispatcher("/consultarproductos.jsp");
			rd.forward(request, response);
		}else{
			List<Cliente> listaCli = servicioCliente.findByCliCedula("");
			request.setAttribute("CLIENTE", listaCli);
			// redireccionar a la vista
			System.out.print("2");
			RequestDispatcher rd = request.getServletContext()
					.getRequestDispatcher("/consultarcliente.jsp");
			rd.forward(request, response);
			
		}
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
