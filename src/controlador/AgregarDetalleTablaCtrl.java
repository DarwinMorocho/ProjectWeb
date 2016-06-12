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
import modelo.Producto;

/**
 * Servlet implementation class AgregarDetalleTablaCtrl
 */
@WebServlet("/AgregarDetalleTablaCtrl")
public class AgregarDetalleTablaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		List<DetalleFactura> detalles = (List<DetalleFactura>) request.getAttribute("DETALLES1");
		System.out.println("detalles . descripcion"+detalles.get(0).getDetDescripcion());
		String producto = request.getParameter("producto_factura");
		String cantidad = request.getParameter("cantidad_factura");
		String descripcion = request.getParameter("descripcion_factura");
		String subtotal = request.getParameter("subtotal_factura");
		String total = request.getParameter("total_factura");
//		List<DetalleFactura> detallesFactura = new ArrayList<DetalleFactura>();
		DetalleFactura detalleFactura = new DetalleFactura();
		detalleFactura.setProducto(new Producto());
		detalleFactura.setDetCantidad(new java.math.BigDecimal("0.01"));
		detalleFactura.setDetDescripcion("niguna");
		detalleFactura.setDetSubtotal(new java.math.BigDecimal("2.45"));
		detalleFactura.setDetTotal(new java.math.BigDecimal("4.5"));
		
		detalles.add(detalleFactura);
		request.setAttribute("DETALLES", detalles);
		
		System.out.println("AgregarDetalleTablaCtrl");
		RequestDispatcher rd = request.getServletContext()
				.getRequestDispatcher("/factura.jsp");
		rd.forward(request, response);

	}
}
