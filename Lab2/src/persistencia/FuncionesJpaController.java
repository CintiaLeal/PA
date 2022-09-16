/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Logica.Funciones;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author romil
 */
public class FuncionesJpaController implements Serializable {

    public FuncionesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public  FuncionesJpaController(){
    emf = Persistence.createEntityManagerFactory("Labo1PU");
    }

    public void create(Funciones funciones) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(funciones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFunciones(funciones.getNombre()) != null) {
                throw new PreexistingEntityException("Funciones " + funciones + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Funciones funciones) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            funciones = em.merge(funciones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = funciones.getNombre();
                if (findFunciones(id) == null) {
                    throw new NonexistentEntityException("The funciones with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funciones funciones;
            try {
                funciones = em.getReference(Funciones.class, id);
                funciones.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funciones with id " + id + " no longer exists.", enfe);
            }
            em.remove(funciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Funciones> findFuncionesEntities() {
        return findFuncionesEntities(true, -1, -1);
    }

    public List<Funciones> findFuncionesEntities(int maxResults, int firstResult) {
        return findFuncionesEntities(false, maxResults, firstResult);
    }

    private List<Funciones> findFuncionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Funciones.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Funciones findFunciones(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funciones.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Funciones> rt = cq.from(Funciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
