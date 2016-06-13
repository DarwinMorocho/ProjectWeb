package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DetalleFactura;
import modelo.Producto;
import servicios.ServicioProducto;

/**
 * Servlet implementation class AgregarDetalleTablaCtrl
 */
@WebServlet("/AgregarDetalleTablaCtrl")
public class AgregarDetalleTablaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServicioProducto servicioProducto= new ServicioProducto();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarDetalleTablaCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String producto = request.getParameter("producto_factura");
		String cantidad = request.getParameter("cantidad_factura");
		String descripcion = request.getParameter("descripcion_factura");
		String subtotal = request.getParameter("subtotal_factura");
		String total = request.getParameter("total_factura");
//		List<DetalleFactura> detallesFactura = new ArrayList<DetalleFactura>();
		
		Producto productoElegido = servicioProducto.findByIdProducto(Integer.valueOf(producto));
		DetalleFactura detalleFactura = new DetalleFactura();
		detalleFactura.setProducto(productoElegido);
		detalleFactura.setDetCantidad(BigDecimal.valueOf(Double.valueOf(cantidad)));
		//detalleFactura.setDetDescripcion("niguna");
		detalleFactura.setDetSubtotal(BigDecimal.valueOf(Double.valueOf(subtotal)));
		detalleFactura.setDetTotal(BigDecimal.valueOf(Double.valueOf(total)));
		
		GuardaDetalleTemporal.detallesFactura.add(detalleFactura);
		request.setAttribute("DETALLES", GuardaDetalleTemporal.detallesFactura);
		
		System.out.println("AgregarDetalleTablaCtrl");
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/nuevaFactura.jsp");
		rd.forward(request, response);

	}
}
