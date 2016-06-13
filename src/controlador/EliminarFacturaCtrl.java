package controlador;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.DetalleFactura;
import modelo.Factura;
import servicios.ServicioDetalleFactura;
import servicios.ServicioFactura;

/**
 * Servlet implementation class EliminarFacturaCtrl
 */
@WebServlet("/EliminarFacturaCtrl")
public class EliminarFacturaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicioFactura servicioFactura= new ServicioFactura();
	ServicioDetalleFactura servicioDetalleFactura = new ServicioDetalleFactura();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarFacturaCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try{
			System.out.println("ingresa a eliminar factura");
			String id = request.getParameter("id");
			Factura facturaEliminar= servicioFactura.findOneByIdFactura(Integer.valueOf(id));
			List<DetalleFactura> listaDetalles = facturaEliminar.getDetalleFacturas();
			
			// Borrar detalles asociados a factura
			Iterator iterator = listaDetalles.iterator();
			
			while(iterator.hasNext()){
				DetalleFactura detalle = (DetalleFactura)iterator.next();
				System.out.println(detalle.toString());
				servicioDetalleFactura.eliminar(detalle);
			}
			
			// Borrar factura
			servicioFactura.eliminar(facturaEliminar);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		List<Factura> listaFacturas= servicioFactura.findAll();
		request.setAttribute("FACTURA", listaFacturas);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/consultarFacturas.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
