package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.Factura;
import modelo.Usuario;
import servicios.LoginSession;
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
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       
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

		Factura factura = (Factura) servicioFactura.findByIdFactura(Integer.valueOf(id));
		request.setAttribute("FACTURA", factura);
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
            
			//String estado = request.getParameter("facEstado");
			String cliente = request.getParameter("fac_cliente");
			//String usuario = request.getParameter("fac_usuario");//??????????????
			String numeroFactura = request.getParameter("fac_numero");
			String fecha = request.getParameter("fac_fecha");// "11-11-2012";		
			Date inputDate = dateFormat.parse(fecha);
			String subtotal = request.getParameter("fac_subtotal");
			String iva = request.getParameter("fac_iva");
			String total = request.getParameter("fac_total");
					
			if(numeroFactura!=null){
				
				// Encontrar objeto Usuario
				//Usuario usuarioLogin = servicioUsuario.findOneByIdUsuario(Integer.parseInt(usuario));			
				Usuario usuarioLogin = LoginSession.getInstance().getUsuarioLogueado();
				
				// Encontrar objeto Usuario
				Cliente clienteEscogido = servicioCliente.findByIdCliente(Integer.parseInt(cliente));
				
				Factura facturaModificada = new Factura();
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
		//System.out.print("2");
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/consultarFacturas.jsp");
		rd.forward(request, response);
	}

}