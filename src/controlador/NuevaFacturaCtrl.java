package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
 * Servlet implementation class NuevaFacturaCtrl
 */
@WebServlet("/NuevaFacturaCtrl")
public class NuevaFacturaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServicioFactura servicioFactura= new ServicioFactura();
	//ServicioUsuario servicioUsuario= new ServicioUsuario();
	ServicioCliente servicioCliente= new ServicioCliente();
	ServicioProducto servicioProducto= new ServicioProducto();
	ServicioDetalleFactura servicioDetalleFactura = new ServicioDetalleFactura();

	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//"dd/MM/yyyy"

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaFacturaCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// llenar combo clientes
		List<Cliente> listaClientes= servicioCliente.findAll();
		request.setAttribute("CLIENTE", listaClientes);
		
		List<Producto> listaProductos= servicioProducto.findAll();
		request.setAttribute("PRODUCTO", listaProductos);
		
		List<DetalleFactura> detalles = GuardaDetalleTemporal.detallesFactura;
		//detalles = servicioDetalleFactura.findByFactura(factura);
		
		request.setAttribute("DETALLES", detalles);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
				
		try {
            
			//String estado = request.getParameter("facEstado");
			String cliente = request.getParameter("fac_cliente");
			//String usuario = request.getParameter("fac_usuario");//??????????????
			String numeroFactura = request.getParameter("fac_numero");
			String fecha = request.getParameter("fac_fecha");// "11-11-2012";
			System.out.println(fecha);
			Date inputDate = dateFormat.parse(fecha);
			String subtotal = request.getParameter("fac_subtotal");
			String iva = request.getParameter("fac_iva");
			String total = request.getParameter("fac_total");
					
			if(numeroFactura!=null){
				
				// Encontrar objeto Usuario
				//Usuario usuarioLogin = servicioUsuario.findOneByIdUsuario(Integer.parseInt(usuario));			
				//Usuario usuarioLogin = LoginSession.getInstance().getUsuarioLogueado();
				HttpSession session = request.getSession();			
				Usuario usuarioLogin = (Usuario) session.getAttribute("usuario");
				// Encontrar objeto Usuario
				Cliente clienteEscogido = servicioCliente.findByIdCliente(Integer.parseInt(cliente));
				
				Factura nuevaFactura = new Factura();
				nuevaFactura.setCliente(clienteEscogido);
				nuevaFactura.setUsuario(usuarioLogin);
				nuevaFactura.setFacNumero(Integer.parseInt(numeroFactura));
				nuevaFactura.setFacFecha(inputDate);
				nuevaFactura.setFacSubtotal(BigDecimal.valueOf(Double.valueOf(subtotal)));
				nuevaFactura.setFacIva(BigDecimal.valueOf(Double.valueOf(iva)));
				nuevaFactura.setFacTotal(BigDecimal.valueOf(Double.valueOf(total)));
				
				servicioFactura.crear(nuevaFactura);
				
			}
			// Guardar los detalles
			// primero obtener id de factura creada y luego establecer ese id a todos los detalles
			
			// Limpiar variables
			GuardaDetalleTemporal.detallesFactura.clear();


        } catch (Exception e) {
            System.out.println("Error en guardar Factura" + e);
        }

		
//		Producto producto = (Producto) servicioProducto.findByIdProducto(Integer.valueOf(id));
//		request.setAttribute("PRODUCTO", producto);
		// redireccionar a la vista
		//System.out.print("2");		
		
		List<Factura> listaFacturas= servicioFactura.findAll();
		request.setAttribute("FACTURA", listaFacturas);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/consultarFacturas.jsp");
		rd.forward(request, response);
		
		
		
		
	}

}
