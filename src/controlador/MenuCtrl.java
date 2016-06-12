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

import servicios.ServicioCliente;
import servicios.ServicioProducto;
import modelo.Cliente;
import modelo.DetalleFactura;
import modelo.Producto;

/**
 * Servlet implementation class MenuCtrl
 */
@WebServlet("/MenuCtrl")
public class MenuCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicioProducto servicioProducto = new ServicioProducto();
	ServicioCliente servicioCliente = new ServicioCliente();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuCtrl() {
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

		String prod = request.getParameter("par");
		System.out.println("entra al serlevt  menu " + prod);
		if (prod.equals("producto")) {

			List<Producto> listaProd = servicioProducto.findByProdNombre("");
			request.setAttribute("PRODUCTO", listaProd);
			// redireccionar a la vista
			System.out.print("1");
			RequestDispatcher rd = request.getServletContext()
					.getRequestDispatcher("/consultarproductos.jsp");
			rd.forward(request, response);
		} else if (prod.equals("factura")) {
//			String producto = request.getParameter("producto_factura");
//			String cantidad = request.getParameter("cantidad_factura");
//			String descripcion = request.getParameter("descripcion_factura");
//			String subtotal = request.getParameter("subtotal_factura");
//			String total = request.getParameter("total_factura");
//			List<DetalleFactura> detallesFactura = new ArrayList<DetalleFactura>();
//			DetalleFactura detalleFactura = new DetalleFactura();
//			detalleFactura.setProducto(new Producto());
//			detalleFactura.setDetCantidad(new java.math.BigDecimal("0.01"));
//			detalleFactura.setDetDescripcion("niguna");
//			detalleFactura.setDetSubtotal(new java.math.BigDecimal("2.45"));
//			detalleFactura.setDetTotal(new java.math.BigDecimal("4.5"));
//
//			detallesFactura.add(detalleFactura);
//			request.setAttribute("DETALLES", detallesFactura);
			RequestDispatcher rd = request.getServletContext()
					.getRequestDispatcher("/factura.jsp");
			rd.forward(request, response);

		} else {
			List<Cliente> listaCli = servicioCliente.findByCliCedula("");
			request.setAttribute("CLIENTE", listaCli);
			// redireccionar a la vista
			System.out.print("2");
			RequestDispatcher rd = request.getServletContext()
					.getRequestDispatcher("/consultarcliente.jsp");
			rd.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
