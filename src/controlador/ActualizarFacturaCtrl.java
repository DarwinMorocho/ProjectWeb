package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Cliente;
import modelo.Factura;
import modelo.Usuario;
import servicios.ServicioCliente;
import servicios.ServicioFactura;

/**
 * Servlet implementation class ActualizarFacturaCtrl
 */
@WebServlet("/ActualizarFacturaCtrl")
public class ActualizarFacturaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServicioFactura servicioFactura= new ServicioFactura();
	//ServicioUsuario servicioUsuario= new ServicioUsuario();
	ServicioCliente servicioCliente= new ServicioCliente();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//"dd/MM/yyyy"
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarFacturaCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");

		Factura factura = (Factura) servicioFactura.findByIdFactura(Integer.valueOf(id)).get(0);
		request.setAttribute("FACTURA", factura);
		
		List<Cliente> listaClientes= servicioCliente.findAll();
		request.setAttribute("CLIENTE", listaClientes);
		// redireccionar a la vista
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/actualizarFactura.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
            
			String id = request.getParameter("id");
			String cliente = request.getParameter("fac_cliente");
			//String usuario = request.getParameter("fac_usuario");//??????????????
			String numeroFactura = request.getParameter("fac_numero");
			String fecha = request.getParameter("fac_fecha");// "11-11-2012";		
			Date inputDate = dateFormat.parse(fecha);
			String subtotal = request.getParameter("fac_subtotal");
			String iva = request.getParameter("fac_iva");
			String total = request.getParameter("fac_total");
					
			System.out.println("ACTUALIZAR FACTURA ");
			if(numeroFactura!=null){
				
				// Encontrar objeto Usuario
				//Usuario usuarioLogin = servicioUsuario.findOneByIdUsuario(Integer.parseInt(usuario));			
				//Usuario usuarioLogin = LoginSession.getInstance().getUsuarioLogueado();
				HttpSession session = request.getSession();			
				Usuario usuarioLogin = (Usuario) session.getAttribute("usuario");
				System.out.println("Sesion del usuario "+usuarioLogin.getIdUsuario());
				// Encontrar objeto Usuario
				Cliente clienteEscogido = servicioCliente.findByIdCliente(Integer.parseInt(cliente));
				
				Factura facturaModificada = new Factura();
				facturaModificada.setIdFactura(Integer.parseInt(id));
				facturaModificada.setCliente(clienteEscogido);
				facturaModificada.setUsuario(usuarioLogin);
				facturaModificada.setFacNumero(Integer.parseInt(numeroFactura));
				facturaModificada.setFacFecha(inputDate);
				facturaModificada.setFacSubtotal(BigDecimal.valueOf(Double.valueOf(subtotal)));
				facturaModificada.setFacIva(BigDecimal.valueOf(Double.valueOf(iva)));
				facturaModificada.setFacTotal(BigDecimal.valueOf(Double.valueOf(total)));
				
				servicioFactura.modificar(facturaModificada);
				
			}


        } catch (Exception e) {
            System.out.println("Error en guardar Factura" + e);
        }

		

		// redireccionar a la vista
		List<Factura> listaFacturas= servicioFactura.findAll();
		request.setAttribute("FACTURA", listaFacturas);
		//redireccionar a la vista
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/consultarFacturas.jsp");
		rd.forward(request, response);
	}

}
