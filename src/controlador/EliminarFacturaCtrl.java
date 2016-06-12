package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.Factura;
import servicios.ServicioFactura;

/**
 * Servlet implementation class EliminarFacturaCtrl
 */
@WebServlet("/EliminarFacturaCtrl")
public class EliminarFacturaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicioFactura servicioFactura= new ServicioFactura();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarFacturaCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("ingresa a eliminar factura");
		String id = request.getParameter("id");
		Factura facturaEliminar= new Factura();
		facturaEliminar.setIdFactura(Integer.valueOf(id));
		servicioFactura.eliminar(facturaEliminar);

		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/consultarFacturas.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
