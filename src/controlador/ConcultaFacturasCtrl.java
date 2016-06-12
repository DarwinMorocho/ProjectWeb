package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Factura;
import servicios.ServicioFactura;

/**
 * Servlet implementation class ConcultaFacturasCtrl
 */
@WebServlet("/ConcultaFacturasCtrl")
public class ConcultaFacturasCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConcultaFacturasCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		String idCliente = request.getParameter("id");
		//DEVOLVER UNA LISTA DE LAS FACTURAS QUE PERTENECEN AL USUARIO
		
		ServicioFactura servicioFactura = new ServicioFactura();
		List<Factura> facturasUsuario= servicioFactura.findAll();
		
		request.setAttribute("FACTURAS", facturasUsuario);
		RequestDispatcher rd= request.getServletContext().getRequestDispatcher("/consultaFacturas.jsp");
		rd.forward(request, response);
		
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
