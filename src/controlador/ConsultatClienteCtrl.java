package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.Producto;
import servicios.ServicioCliente;

/**
 * Servlet implementation class ConsultatClienteCtrl
 */
@WebServlet("/ConsultatClienteCtrl")
public class ConsultatClienteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServicioCliente servicioCliente= new ServicioCliente();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultatClienteCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("txtBuscar");
		
		
		List<Cliente> listaProd= servicioCliente.findByCliCedula(nombre);
		request.setAttribute("CLIENTE", listaProd);
		//redireccionar a la vista
		
		RequestDispatcher rd = 
				request.getServletContext().getRequestDispatcher(
						"/consultarcliente.jsp");
		rd.forward(request, response);
		
	}

}
