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

import modelo.DetalleFactura;
import modelo.Factura;
import modelo.Factura;

/**
 *
 * @author gato
 */
public class ServicioDetalleFactura {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void crear(DetalleFactura detalleFactura) {

		try {
			System.out.println("id prod "+detalleFactura.getProducto().getIdProducto());
			System.out.println("id cant "+detalleFactura.getDetCantidad());
			System.out.println("id subt "+detalleFactura.getDetSubtotal());
			System.out.println("id total "+detalleFactura.getDetTotal());
			System.out.println("id factura "+detalleFactura.getFactura().getIdFactura());
			
			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			System.out.println("aaaaaaaaaaaaaaa");
			em.persist(detalleFactura);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en insertar Detalle Factura");
		} finally {
			em.close();
		}

	}

	public void eliminar(DetalleFactura detalleFactura) {

		try {
			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			em.remove(em.merge(detalleFactura));
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error en eliminar  Factura" + e);
		} finally {
			em.close();
		}

	}

	public void modificar(Factura detalleFactura) {

		try {
			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			em.merge(detalleFactura);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en insertar Factura");
		} finally {
			em.close();
		}

	}

	public List<DetalleFactura> findAll() {

		List<DetalleFactura> listaDetalleFactura = new ArrayList<DetalleFactura>();
		try {
			// Connection connection = em.unwrap(Connection.class);

			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("DetalleFactura.findAll",
					DetalleFactura.class);
			// query.setParameter("perCedula", cedula);
			listaDetalleFactura = (List<DetalleFactura>) query.getResultList();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out
					.println("Error en lsa consulta Factura" + e.getMessage());
		} finally {
			em.close();
		}

		return listaDetalleFactura;
	}

	public List<DetalleFactura> findByIdDetalle(Integer valor) {

		List<DetalleFactura> listaDetalleFactura = new ArrayList<DetalleFactura>();
		try {
			// Connection connection = em.unwrap(Connection.class);

			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("DetalleFactura.findByIdDetalle",
					DetalleFactura.class);
			query.setParameter("idDetalle", valor);
			listaDetalleFactura = (List<DetalleFactura>) query.getResultList();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en lsa consulta Factura");
		} finally {
			em.close();
		}

		return listaDetalleFactura;
	}

	public List<DetalleFactura> findByFactura(Factura valor) {

		List<DetalleFactura> listaFacturas = new ArrayList<DetalleFactura>();
		try {
			// Connection connection = em.unwrap(Connection.class);

			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("DetalleFactura.findByFactura",
					DetalleFactura.class);
			query.setParameter("factura", valor);
			listaFacturas = (List<DetalleFactura>) query.getResultList();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en lsa consulta Factura");
		} finally {
			em.close();
		}

		return listaFacturas;
	}

}
