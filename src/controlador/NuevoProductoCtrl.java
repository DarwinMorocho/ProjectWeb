package controlador;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.ServicioProducto;
import modelo.Producto;

/**
 * Servlet implementation class NuevoProductoCtrl
 */
@WebServlet("/NuevoProductoCtrl")
public class NuevoProductoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServicioProducto servicioProducto= new ServicioProducto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoProductoCtrl() {
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
	
		String name = request.getParameter("name");
		String cod = request.getParameter("cod");
		String cost = request.getParameter("cost");
		if(name!=null){
			Producto prod = new Producto(
					BigDecimal.valueOf(Double.valueOf(cost)), cod, 1, name);
			servicioProducto.crear(prod);
		}
		
	
		
//		Producto producto = (Producto) servicioProducto.findByIdProducto(Integer.valueOf(id));
//		request.setAttribute("PRODUCTO", producto);
		// redireccionar a la vista
		System.out.print("2");
		RequestDispatcher rd = 
				request.getServletContext().getRequestDispatcher(
						"/consultarproductos.jsp");
		rd.forward(request, response);
	}
	

}
