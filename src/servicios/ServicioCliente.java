/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cliente;

/**
 *
 * @author gato
 */
public class ServicioCliente {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void crear(Cliente cliente) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar Cliente");
        } finally {
            em.close();
        }

    }

    public void eliminar(Cliente cliente) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(cliente));
            em.getTransaction().commit();



        } catch (Exception e) {
            System.out.println("Error en eliminar  Cliente" + e);
        } finally {
            em.close();
        }

    }

    public void modificar(Cliente cliente) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar Cliente");
        } finally {
            em.close();
        }

    }

    public List<Cliente> findAll() {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            //Connection connection = em.unwrap(Connection.class);

            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Cliente.findAll", Cliente.class);
//            query.setParameter("perCedula", cedula);
            listaClientes = (List<Cliente>) query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta Cliente" +e.getMessage());
        } finally {
            em.close();
        }

        return listaClientes;
    }

    public List<Cliente> findByIdCliente(Integer valor) {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            //Connection connection = em.unwrap(Connection.class);

            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Cliente.findByIdCliente", Cliente.class);
            query.setParameter("idCliente", valor);
            listaClientes = (List<Cliente>) query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta Cliente");
        } finally {
            em.close();
        }

        return listaClientes;
    }

    

    public List<Cliente> findByCliCedula(String valor) {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            //Connection connection = em.unwrap(Connection.class);

            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Cliente.findByCliCedula", Cliente.class);
            query.setParameter("cliCedula", valor);
            listaClientes = (List<Cliente>) query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta Cliente");
        } finally {
            em.close();
        }

        return listaClientes;
    }

}
