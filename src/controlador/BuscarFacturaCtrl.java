package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Factura;
import modelo.Producto;
import servicios.ServicioFactura;

/**
 * Servlet implementation class BuscarFacturaCtrl
 */
@WebServlet("/BuscarFacturaCtrl")
public class BuscarFacturaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServicioFactura servicioFactura= new ServicioFactura();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarFacturaCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String numeroFactura = request.getParameter("txtBuscar");
		
		
		List<Factura> listaFacturas= servicioFactura.findByFacNumero(numeroFactura);
		request.setAttribute("FACTURAS", listaFacturas);
		//redireccionar a la vista
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/consultarproductos.jsp");
		rd.forward(request, response);
	}

}
