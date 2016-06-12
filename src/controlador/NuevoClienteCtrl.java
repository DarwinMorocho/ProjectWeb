package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.ServicioCliente;
import modelo.Cliente;

/**
 * Servlet implementation class NuevoClienteCtrl
 */
@WebServlet("/NuevoClienteCtrl")
public class NuevoClienteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicioCliente servicioCliente = new ServicioCliente();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NuevoClienteCtrl() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("ingresa a act cli");

		String ced = request.getParameter("ced");
		String name = request.getParameter("name");
		String raz = request.getParameter("raz");
		String dir = request.getParameter("dir");
		String tel = request.getParameter("tel");
		String mov = request.getParameter("mov");
		String cor = request.getParameter("cor");
		if (name != null) {
			Cliente cli = new Cliente(ced, cor, dir, mov, name, raz, tel);
			servicioCliente.crear(cli);
		}

		RequestDispatcher rd = request.getServletContext()
				.getRequestDispatcher("/consultarcliente.jsp");
		rd.forward(request, response);
	}

}
