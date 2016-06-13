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
 * Servlet implementation class ActualizarProcutoCtrl
 */
@WebServlet("/ActualizarProductoCtrl")
public class ActualizarProductoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServicioProducto servicioProducto = new ServicioProducto();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActualizarProductoCtrl() {
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

		String id = request.getParameter("id");

		List<Categoria> categorias = new ArrayList<Categoria>();
		ServicioCategoria servicioCategoria = new ServicioCategoria();
		categorias = servicioCategoria.findAll();
		request.setAttribute("CATEGORIAS", categorias);

		Producto producto = (Producto) servicioProducto
				.findByIdProducto(Integer.valueOf(id));
		request.setAttribute("PRODUCTO", producto);
		// redireccionar a la vista
		System.out.print("2");
		RequestDispatcher rd = request.getServletContext()
				.getRequestDispatcher("/actualizarProducto.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String cod = request.getParameter("cod");
		String cost = request.getParameter("cost");
		String idCategoria = request.getParameter("opcionSeleccionada");
		Categoria categoria = new Categoria();
		ServicioCategoria servicioCategoria = new ServicioCategoria();
		categoria = servicioCategoria.findByIdCategoria(Integer.parseInt(idCategoria)).get(0);
		if (name != null) {
			Producto prod = new Producto(Integer.valueOf(id),
					BigDecimal.valueOf(Double.valueOf(cost)), cod, 1, name);
			prod.setCategoria(categoria);
			servicioProducto.modificar(prod);
		}

		List<Producto> listaProd = servicioProducto.findByProdNombre("");
		request.setAttribute("PRODUCTO", listaProd);
		// redireccionar a la vista
		System.out.print("2");
		RequestDispatcher rd = request.getServletContext()
				.getRequestDispatcher("/consultarproductos.jsp");
		rd.forward(request, response);
	}

}
