package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.Client;

import modelo.Cliente;
import modelo.DetalleFactura;
import modelo.Factura;
import modelo.Producto;
import servicios.ServicioCliente;
import servicios.ServicioProducto;

/**
 * Servlet implementation class AgregarDetalleTablaCtrl
 */
@WebServlet("/AgregarDetalleTablaCtrl")
public class AgregarDetalleTablaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServicioProducto servicioProducto = new ServicioProducto();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarDetalleTablaCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		// if(accion.equals("agregarDetalle")){
		// String idProducto = request.getParameter("selCombo");
		// // String cantidad = request.getParameter("cantidad_factura");
		// // String descripcion = request.getParameter("descripcion_factura");
		// // String subtotal = request.getParameter("subtotal_factura");
		// String total = request.getParameter("total_factura");
		// // List<DetalleFactura> detallesFactura = new
		// ArrayList<DetalleFactura>();
		//
		// Producto productoElegido =
		// servicioProducto.findByIdProducto(Integer.valueOf(idProducto));
		// // DetalleFactura detalleFactura = new DetalleFactura();
		// // detalleFactura.setProducto(productoElegido);
		// //
		// detalleFactura.setDetCantidad(BigDecimal.valueOf(Double.valueOf(cantidad)));
		// // //detalleFactura.setDetDescripcion("niguna");
		// //
		// detalleFactura.setDetSubtotal(BigDecimal.valueOf(Double.valueOf(subtotal)));
		// //
		// detalleFactura.setDetTotal(BigDecimal.valueOf(Double.valueOf(total)));
		// DetalleFactura detalleFactura = new DetalleFactura();
		// detalleFactura.setProducto(productoElegido);
		// detalleFactura.setDetCantidad(new java.math.BigDecimal("4.2"));
		// detalleFactura.setDetDescripcion("niguna");
		// detalleFactura.setDetSubtotal(new java.math.BigDecimal("8.2"));
		// detalleFactura.setDetTotal(new java.math.BigDecimal("9.2"));
		// GuardaDetalleTemporal.detallesFactura.add(detalleFactura);
		// request.setAttribute("DETALLES",
		// GuardaDetalleTemporal.detallesFactura);
		//
		//
		// ServicioProducto servicioProducto= new ServicioProducto();
		// List<Producto> listaProd= servicioProducto.findAll();
		// request.setAttribute("PRODUCTO", listaProd);
		//
		// System.out.println("AgregarDetalleTablaCtrl");
		// RequestDispatcher rd =
		// request.getServletContext().getRequestDispatcher("/nuevaFactura.jsp");
		// rd.forward(request, response);
		// }
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Factura factura = agregarCabecera(request);

		String idProducto = request.getParameter("selCombo");
		String cantidad = request.getParameter("cantidad_factura");
		String descripcion = request.getParameter("descripcion_factura");
		// String subtotal = request.getParameter("subtotal_factura");
		// String total = request.getParameter("total_factura");
		// List<DetalleFactura> detallesFactura = new
		// ArrayList<DetalleFactura>();

		Producto productoElegido = servicioProducto.findByIdProducto(Integer
				.valueOf(idProducto));
		// DetalleFactura detalleFactura = new DetalleFactura();
		// detalleFactura.setProducto(productoElegido);
		// detalleFactura.setDetCantidad(BigDecimal.valueOf(Double.valueOf(cantidad)));
		// //detalleFactura.setDetDescripcion("niguna");
		// detalleFactura.setDetSubtotal(BigDecimal.valueOf(Double.valueOf(subtotal)));
		// detalleFactura.setDetTotal(BigDecimal.valueOf(Double.valueOf(total)));
		DetalleFactura detalleFactura = new DetalleFactura();
		detalleFactura.setProducto(productoElegido);
		detalleFactura.setDetCantidad(new java.math.BigDecimal(cantidad));
		detalleFactura.setDetDescripcion(descripcion);
		detalleFactura.setDetSubtotal(productoElegido.getPordCostoVentaFinal()
				.multiply(new java.math.BigDecimal(cantidad)));
		productoElegido.getPordCostoVentaFinal().multiply(
				new java.math.BigDecimal(cantidad));
		detalleFactura.setDetTotal(productoElegido.getPordCostoVentaFinal()
				.multiply(new java.math.BigDecimal(cantidad)));
		GuardaDetalleTemporal.detallesFactura.add(detalleFactura);
		request.setAttribute("DETALLES", GuardaDetalleTemporal.detallesFactura);

		
		ServicioProducto servicioProducto = new ServicioProducto();
		List<Producto> listaProd = servicioProducto.findAll();
		request.setAttribute("PRODUCTO", listaProd);

		request.setAttribute("FACTURA", factura);
		System.out.println("AgregarDetalleTablaCtrl");
		RequestDispatcher rd = request.getServletContext()
				.getRequestDispatcher("/nuevaFactura.jsp");
		rd.forward(request, response);
	}

	public Factura agregarCabecera(HttpServletRequest request) {
		String fac_cliente = request.getParameter("fac_cliente");
		String fac_numero = request.getParameter("fac_numero");
		String fac_fecha = request.getParameter("fac_fecha");
		String fac_iva = request.getParameter("fac_iva");
		String fac_subtotal = request.getParameter("fac_subtotal");
		String fac_total = request.getParameter("fac_total");
		Factura factura = new Factura();
		ServicioCliente cliente = new ServicioCliente();

		factura.setCliente(cliente.findByIdCliente(Integer.parseInt("1")));
		factura.setFacFecha(Date.valueOf(fac_fecha));
		factura.setFacNumero(Integer.parseInt(fac_numero));
		factura.setFacIva(new java.math.BigDecimal(fac_iva));
		factura.setFacSubtotal(new java.math.BigDecimal(fac_subtotal));
		factura.setFacTotal(new java.math.BigDecimal(fac_total));

		return factura;
	}

}
