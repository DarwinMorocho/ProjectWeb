package controlador;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.ServicioCliente;
import modelo.Cliente;
import modelo.Producto;

/**
 * Servlet implementation class ActualizarClienteCtrl
 */
@WebServlet("/ActualizarClienteCtrl")
public class ActualizarClienteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServicioCliente servicioCliente = new ServicioCliente();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActualizarClienteCtrl() {
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

		Cliente cliente = (Cliente) servicioCliente.findByIdCliente(Integer
				.valueOf(id));
		request.setAttribute("CLIENTE", cliente);
		// redireccionar a la vista
		RequestDispatcher rd = request.getServletContext()
				.getRequestDispatcher("/actualizarcliente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ingresa a act cli");
		String id = request.getParameter("id");
		String ced = request.getParameter("ced");
		String name = request.getParameter("name");
		String raz = request.getParameter("raz");
		String dir = request.getParameter("dir");
		String tel = request.getParameter("tel");
		String mov = request.getParameter("mov");
		String cor = request.getParameter("cor");
		if (name != null) {
			Cliente cli = new Cliente(Integer.valueOf(id), ced, cor, dir, mov,
					name, raz, tel);
			servicioCliente.modificar(cli);
		}

		RequestDispatcher rd = request.getServletContext()
				.getRequestDispatcher("/consultarcliente.jsp");
		rd.forward(request, response);
	}

}
