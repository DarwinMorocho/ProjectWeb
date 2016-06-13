package controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.ServicioCategoria;
import servicios.ServicioProducto;
import modelo.Categoria;
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
		String accion = request.getParameter("accion");
		if(accion.equals("recuperarCategoria")){
			List<Categoria> categorias = new ArrayList<Categoria>();
			ServicioCategoria servicioCategoria = new ServicioCategoria();
			categorias= servicioCategoria.findAll();
			
			request.setAttribute("CATEGORIAS", categorias);
			
			RequestDispatcher rd = 
					request.getServletContext().getRequestDispatcher(
							"/nuevoproducto.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	System.out.println("valor categoria  "+  request.getParameter("opcionSeleccionada"));
		String name = request.getParameter("name");
		String cod = request.getParameter("cod");
		String cost = request.getParameter("cost");
		Integer id = Integer.parseInt(request.getParameter("opcionSeleccionada"));
		ServicioCategoria servicioCategoria = new ServicioCategoria();
		Categoria categorias = new Categoria();
		categorias=servicioCategoria.findByIdCategoria(id).get(0);
		
		
		if(name!=null){
			Producto prod = new Producto(
					BigDecimal.valueOf(Double.valueOf(cost)), cod, 1, name);
			prod.setCategoria(categorias);
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
