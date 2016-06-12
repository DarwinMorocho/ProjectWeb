package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import modelo.Usuario;
import servicios.LoginSession;
import servicios.ServicioProducto;
import servicios.ServicioUsuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServicioUsuario servicioUsuario= new ServicioUsuario();
	ServicioProducto servicioProducto= new ServicioProducto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String usuario=request.getParameter("usuario");
				String password=request.getParameter("password");
				Usuario usu=servicioUsuario.validarUsuario(usuario, password);
				System.out.println("entra al serlevt "+usuario+"   "+password);
			//	System.out.println("recuperado "+usu.getUsuLogin()+" pass"+usu.getUsuPassword());
				if(usu!=null){
					
					System.out.println("ingresa al sistema");
					LoginSession.getInstance().setUsuarioLogueado(usu);
//					List<Producto> listaProd= servicioProducto.findAll();
//					request.setAttribute("PRODUCTO", listaProd);
					RequestDispatcher rd = 
							request.getServletContext().getRequestDispatcher(
									"/consultarproductos.jsp");
					rd.forward(request, response);
					
				}else{
					
					RequestDispatcher rd = 
							request.getServletContext().getRequestDispatcher(
									"/index.jsp");
					rd.forward(request, response);
				}
				
				// TODO Auto-generated method stub
	}

}
