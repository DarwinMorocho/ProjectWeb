/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Usuario;
import modelo.Usuario;
import modelo.Usuario;

/**
 *
 * @author gato
 */
public class ServicioUsuario {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void crear(Usuario usuario) {

		try {
			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en insertar Usuario");
		} finally {
			em.close();
		}

	}

	public void eliminar(Usuario usuario) {

		try {
			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			em.remove(em.merge(usuario));
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error en eliminar  Usuario" + e);
		} finally {
			em.close();
		}

	}

	public void modificar(Usuario usuario) {

		try {
			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en insertar Usuario");
		} finally {
			em.close();
		}

	}

	public List<Usuario> findAll() {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			// Connection connection = em.unwrap(Connection.class);

			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Usuario.findAll", Usuario.class);
			// query.setParameter("perCedula", cedula);
			listaUsuarios = (List<Usuario>) query.getResultList();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out
					.println("Error en lsa consulta Usuario" + e.getMessage());
		} finally {
			em.close();
		}

		return listaUsuarios;
	}

	public List<Usuario> findByIdUsuario(Integer valor) {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			// Connection connection = em.unwrap(Connection.class);

			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Usuario.findByIdUsuario",
					Usuario.class);
			query.setParameter("idUsuario", valor);
			listaUsuarios = (List<Usuario>) query.getResultList();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en lsa consulta Usuario");
		} finally {
			em.close();
		}

		return listaUsuarios;
	}

	public List<Usuario> findByUsuNombre(String valor) {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			// Connection connection = em.unwrap(Connection.class);

			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Usuario.findByUsuNombre",
					Usuario.class);
			query.setParameter("usuNombre", valor);
			listaUsuarios = (List<Usuario>) query.getResultList();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en lsa consulta Usuario");
		} finally {
			em.close();
		}

		return listaUsuarios;
	}

	public Usuario validarUsuario(String usuario, String password) {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Usuario usuario2 = new Usuario();
		try {
			// Connection connection = em.unwrap(Connection.class);

			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Usuario.findByValidarUsuario",
					Usuario.class);
			query.setParameter("usuLogin", usuario);
			query.setParameter("usuPassword", password);

			listaUsuarios = (List<Usuario>) query.getResultList();
			System.out.println("longitud de la lista de usu "+listaUsuarios.size());
			if (listaUsuarios.size() > 0) {
				System.out.println("existe el usuario");
				usuario2 = listaUsuarios.get(0);
			} else {
				System.out.println("no encuentra en la base al usuari");
				usuario2 = null;

			}

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en lsa consulta Usuario");
		} finally {
			em.close();
		}

		return usuario2;
	}
}
