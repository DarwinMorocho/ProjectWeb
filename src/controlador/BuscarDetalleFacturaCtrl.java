package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DetalleFactura;
import modelo.Factura;
import servicios.ServicioDetalleFactura;

/**
 * Servlet implementation class BuscarDetalleFacturaCtrl
 */
@WebServlet("/BuscarDetalleFacturaCtrl")
public class BuscarDetalleFacturaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarDetalleFacturaCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String idFactura = request.getParameter("id");
		ServicioDetalleFactura servicioDetalleFactura = new ServicioDetalleFactura();
		Factura factura = new Factura();
		factura.setIdFactura(Integer.parseInt(idFactura));
		List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
		detalles = servicioDetalleFactura.findByFactura(factura);
		
		request.setAttribute("DETALLES", detalles);
		RequestDispatcher rd= request.getServletContext().getRequestDispatcher("/consultaDetalleFactura.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
