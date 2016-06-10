/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.facelets.Facelet;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Factura;
import modelo.Factura;

/**
 *
 * @author gato
 */
public class ServicioFactura {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void crear(Factura factura) {

		try {
			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			em.persist(factura);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en insertar Factura");
		} finally {
			em.close();
		}

	}

	public void eliminar(Factura factura) {

		try {
			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			em.remove(em.merge(factura));
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error en eliminar  Factura" + e);
		} finally {
			em.close();
		}

	}

	public void modificar(Factura factura) {

		try {
			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			em.merge(factura);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en insertar Factura");
		} finally {
			em.close();
		}

	}

	public List<Factura> findAll() {

		List<Factura> listaFacturas = new ArrayList<Factura>();
		try {
			// Connection connection = em.unwrap(Connection.class);

			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Factura.findAll", Factura.class);
			// query.setParameter("perCedula", cedula);
			listaFacturas = (List<Factura>) query.getResultList();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out
					.println("Error en lsa consulta Factura" + e.getMessage());
		} finally {
			em.close();
		}

		return listaFacturas;
	}

	public List<Factura> findByIdFactura(Integer valor) {

		List<Factura> listaFacturas = new ArrayList<Factura>();
		try {
			// Connection connection = em.unwrap(Connection.class);

			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Factura.findByIdFactura",
					Factura.class);
			query.setParameter("idFactura", valor);
			listaFacturas = (List<Factura>) query.getResultList();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en lsa consulta Factura");
		} finally {
			em.close();
		}

		return listaFacturas;
	}

	public List<Factura> findByFacNumero(String valor) {

		List<Factura> listaFacturas = new ArrayList<Factura>();
		try {
			// Connection connection = em.unwrap(Connection.class);

			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Factura.findByFacNumero",
					Factura.class);
			query.setParameter("facNumero", valor);
			listaFacturas = (List<Factura>) query.getResultList();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en lsa consulta Factura");
		} finally {
			em.close();
		}

		return listaFacturas;
	}

}
