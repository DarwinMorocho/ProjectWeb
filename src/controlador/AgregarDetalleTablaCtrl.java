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
import javax.servlet.http.HttpSession;

//import com.mysql.fabric.xmlrpc.Client;

import modelo.Cliente;
import modelo.DetalleFactura;
import modelo.Factura;
import modelo.Producto;
import modelo.Usuario;
import servicios.ServicioCliente;
import servicios.ServicioDetalleFactura;
import servicios.ServicioFactura;
import servicios.ServicioProducto;
import servicios.ServicioUsuario;

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

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Factura factura = agregarCabecera(request);
		String botonGuardarFactura = request.getParameter("guardarFactura");
		String idProducto = request.getParameter("selCombo");
		String cantidad = request.getParameter("cantidad_factura");
		String descripcion = request.getParameter("descripcion_factura");

		Cliente cliente = new Cliente();
		ServicioCliente servicioCliente = new ServicioCliente();
		cliente = servicioCliente.findByIdCliente(1); // /cambiar este valorq
														// uemado

		if (botonGuardarFactura != null) {
			System.out.println(botonGuardarFactura);
			Producto productoElegido = servicioProducto
					.findByIdProducto(Integer.valueOf(idProducto));
			DetalleFactura detalleFactura = new DetalleFactura();
			detalleFactura.setProducto(productoElegido);
			detalleFactura.setDetCantidad(new java.math.BigDecimal(cantidad));
			detalleFactura.setDetDescripcion(descripcion);
			detalleFactura.setDetSubtotal(productoElegido
					.getPordCostoVentaFinal().multiply(
							new java.math.BigDecimal(cantidad)));
			productoElegido.getPordCostoVentaFinal().multiply(
					new java.math.BigDecimal(cantidad));
			detalleFactura.setDetTotal(productoElegido.getPordCostoVentaFinal()
					.multiply(new java.math.BigDecimal(cantidad)));

			GuardaDetalleTemporal.detallesFactura.add(detalleFactura);
			ServicioFactura servicioFactura = new ServicioFactura();
			HttpSession session = request.getSession();
			Usuario usuarioLogin = (Usuario) session.getAttribute("usuario");
			factura.setCliente(cliente);
			factura.setUsuario(usuarioLogin);

			servicioFactura.crear(factura);
			// factura = servicioFactura.obtenerUltimaFactura();
			List<Factura> facturas = new ArrayList<Factura>();
			facturas = servicioFactura.findAll();
			factura = facturas.get(servicioFactura.findAll().size()-1);
			System.out.println("ULTIMA FACTURA " + factura.getIdFactura());

			for (DetalleFactura df : GuardaDetalleTemporal.detallesFactura) {
				df.setFactura(factura);
				System.out.println("for detalles");
				ServicioDetalleFactura servicioDetalleFactura = new ServicioDetalleFactura();
				servicioDetalleFactura.crear(df);
			}
			GuardaDetalleTemporal.detallesFactura.clear();

			List<Factura> listaFacturas = servicioFactura.findAll();
			request.setAttribute("FACTURA", listaFacturas);
			// redireccionar a la vista
			RequestDispatcher rdFactura = request.getServletContext()
					.getRequestDispatcher("/consultarFacturas.jsp");
			rdFactura.forward(request, response);
		} else {

			Producto productoElegido = servicioProducto
					.findByIdProducto(Integer.valueOf(idProducto));
			DetalleFactura detalleFactura = new DetalleFactura();
			detalleFactura.setProducto(productoElegido);
			detalleFactura.setDetCantidad(new java.math.BigDecimal(cantidad));
			detalleFactura.setDetDescripcion(descripcion);
			detalleFactura.setDetSubtotal(productoElegido
					.getPordCostoVentaFinal().multiply(
							new java.math.BigDecimal(cantidad)));
			productoElegido.getPordCostoVentaFinal().multiply(
					new java.math.BigDecimal(cantidad));
			detalleFactura.setDetTotal(productoElegido.getPordCostoVentaFinal()
					.multiply(new java.math.BigDecimal(cantidad)));
			GuardaDetalleTemporal.detallesFactura.add(detalleFactura);
			request.setAttribute("DETALLES",
					GuardaDetalleTemporal.detallesFactura);
			
			ServicioProducto servicioProducto = new ServicioProducto();
			List<Producto> listaProd = servicioProducto.findAll();
			request.setAttribute("PRODUCTO", listaProd);
			List<Cliente> listaClientes= servicioCliente.findAll();
			request.setAttribute("CLIENTE", listaClientes);
			
			request.setAttribute("FACTURA", factura);

			RequestDispatcher rd = request.getServletContext()
					.getRequestDispatcher("/nuevaFactura.jsp");
			rd.forward(request, response);
		}
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
