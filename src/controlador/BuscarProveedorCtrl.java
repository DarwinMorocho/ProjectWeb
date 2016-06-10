package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;
import modelo.Cliente;
import modelo.DetalleFactura;
import modelo.Factura;
import modelo.Producto;
import modelo.Usuario;
import servicios.ServicioCategoria;
import servicios.ServicioCliente;
import servicios.ServicioDetalleFactura;
import servicios.ServicioFactura;
import servicios.ServicioProducto;
import servicios.ServicioUsuario;

/**
 * Servlet implementation class BuscarProveedorCtrl
 */
@WebServlet("/BuscarProveedorCtrl")
public class BuscarProveedorCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscarProveedorCtrl() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("txtNombre");
		ServicioCategoria servicioProveedor= new ServicioCategoria();
		for (Categoria item : servicioProveedor.findAll()) {
			System.out.println("categoria "+item.getCatNombre());
		}
		
		ServicioCliente servicioCliente= new ServicioCliente();
		
		for (Cliente item : servicioCliente.findAll()) {
			System.out.println("cleinet "+item.getCliCedula());
		}
		ServicioProducto servicioProducto= new ServicioProducto();
		for (Producto item : servicioProducto.findAll()) {
			System.out.println("producto "+item.getProdNombre());
		}
		ServicioUsuario servicioUsuario= new ServicioUsuario();
		for (Usuario item : servicioUsuario.findAll()) {
			System.out.println("usuario "+item.getUsuNombre());
		}
		ServicioFactura servicioFactura= new ServicioFactura();
		for (Factura item : servicioFactura.findAll()) {
			System.out.println("factura "+item.getFacNumero());
		}
		ServicioDetalleFactura servicioDetalleFactura= new ServicioDetalleFactura();
		for (DetalleFactura item : servicioDetalleFactura.findAll()) {
			System.out.println("detalle "+item.getDetDescripcion());
		}
		
		//insert
		Cliente cli= new Cliente("1718276433","ddddddd","ddddddd", "234567","234567","234567", "234567");
		servicioCliente.crear(cli);
		
	}
}
