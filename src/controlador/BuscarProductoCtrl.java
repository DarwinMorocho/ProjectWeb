package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class BuscarProducto
 */
@WebServlet("/BuscarProductoCtrl")
public class BuscarProductoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServicioProducto servicioProducto= new ServicioProducto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProductoCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("txtBuscar");
	
	
		List<Producto> listaProd= servicioProducto.findByProdNombre(nombre);
		request.setAttribute("PRODUCTO", listaProd);
		//redireccionar a la vista
		
		RequestDispatcher rd = 
				request.getServletContext().getRequestDispatcher(
						"/consultarproductos.jsp");
		rd.forward(request, response);
		
		
		
	}

}
