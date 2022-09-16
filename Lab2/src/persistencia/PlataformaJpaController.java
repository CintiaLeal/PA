/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Espectaculo;
import Logica.Plataforma;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Administrador
 */
public class PlataformaJpaController implements Serializable {

    public PlataformaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public  PlataformaJpaController (){
    emf = Persistence.createEntityManagerFactory("Labo1PU");
   
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Plataforma plataforma) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(plataforma);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPlataforma(plataforma.getNombre()) != null) {
                throw new PreexistingEntityException("Plataforma " + plataforma + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void agregarEspectaculo(Plataforma p, Espectaculo e) throws NonexistentEntityException, Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        p.agregarEspectaculoC(e);
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        
    }

    public void edit(Plataforma plataforma) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            plataforma = em.merge(plataforma);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = plataforma.getNombre();
                if (findPlataforma(id) == null) {
                    throw new NonexistentEntityException("The plataforma with id " + id + " no longer exists.");
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
            Plataforma plataforma;
            try {
                plataforma = em.getReference(Plataforma.class, id);
                plataforma.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The plataforma with id " + id + " no longer exists.", enfe);
            }
            em.remove(plataforma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Plataforma> findPlataformaEntities() {
        return findPlataformaEntities(true, -1, -1);
    }

    public List<Plataforma> findPlataformaEntities(int maxResults, int firstResult) {
        return findPlataformaEntities(false, maxResults, firstResult);
    }

    private List<Plataforma> findPlataformaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Plataforma.class));
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

    public Plataforma findPlataforma(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Plataforma.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlataformaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Plataforma> rt = cq.from(Plataforma.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
