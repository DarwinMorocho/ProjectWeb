package servicios;

import modelo.Usuario;

public class LoginSession 
{

	private Usuario usuarioLogueado;


	private static LoginSession instance = null;

	/**
	 * Constructor de la clase (Singleton).
	 */
	protected LoginSession() 
	{
		// Exists only to defeat instantiation.
	}

	/**
	 * M�todo para obtener una �nica instancia de la clase.
	 */
	public static LoginSession getInstance() 
	{
		if(instance == null)
		{
			instance = new LoginSession();
		}
		return instance;
	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

}
