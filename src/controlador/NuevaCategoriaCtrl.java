package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import servicios.ServicioCategoria;
import sun.misc.Cache;

/**
 * Servlet implementation class NuevaCategoriaCtrl
 */
@WebServlet("/NuevaCategoriaCtrl")
public class NuevaCategoriaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NuevaCategoriaCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String cat = request.getParameter("categoria");
		Categoria categoria = new Categoria();
		categoria.setCatNombre(cat);
		ServicioCategoria servicioCategoria = new ServicioCategoria();
		servicioCategoria.crear(categoria);


		
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias = servicioCategoria.findAll();
		
		request.setAttribute("CATEGORIAS", categorias);
		RequestDispatcher rd = request.getServletContext()
				.getRequestDispatcher("/consultaCategoriasProductos.jsp");
		rd.forward(request, response);
	}

}
