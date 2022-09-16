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
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Administrador
 */
public class EspectaculoJpaController implements Serializable {

    public EspectaculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
public  EspectaculoJpaController (){
    emf = Persistence.createEntityManagerFactory("paginaWebPU");
   
    }


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Espectaculo espectaculo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(espectaculo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEspectaculo(espectaculo.getNombre()) != null) {
                throw new PreexistingEntityException("Espectaculo " + espectaculo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Espectaculo espectaculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            espectaculo = em.merge(espectaculo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = espectaculo.getNombre();
                if (findEspectaculo(id) == null) {
                    throw new NonexistentEntityException("The espectaculo with id " + id + " no longer exists.");
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
            Espectaculo espectaculo;
            try {
                espectaculo = em.getReference(Espectaculo.class, id);
                espectaculo.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The espectaculo with id " + id + " no longer exists.", enfe);
            }
            em.remove(espectaculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Espectaculo> findEspectaculoEntities() {
        return findEspectaculoEntities(true, -1, -1);
    }

    public List<Espectaculo> findEspectaculoEntities(int maxResults, int firstResult) {
        return findEspectaculoEntities(false, maxResults, firstResult);
    }

    private List<Espectaculo> findEspectaculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Espectaculo.class));
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

    public Espectaculo findEspectaculo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Espectaculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspectaculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Espectaculo> rt = cq.from(Espectaculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
