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
import modelo.Producto;

/**
 * Servlet implementation class EliminarClienteCtrl
 */
@WebServlet("/EliminarClienteCtrl")
public class EliminarClienteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicioCliente servicioCliente= new ServicioCliente();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarClienteCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ingresa a eliminar cli");
		String id = request.getParameter("id");
		Cliente cli= new Cliente();
		cli.setIdCliente(Integer.valueOf(id));
		servicioCliente.eliminar(cli);

		
		RequestDispatcher rd = 
				request.getServletContext().getRequestDispatcher(
						"/consultarcliente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
