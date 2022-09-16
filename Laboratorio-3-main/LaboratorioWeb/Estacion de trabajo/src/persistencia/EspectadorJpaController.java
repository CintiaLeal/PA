/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Logica.Espectador;
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
 * @author Administrador
 */
public class EspectadorJpaController implements Serializable {

    public EspectadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    
    public  EspectadorJpaController (){
    emf = Persistence.createEntityManagerFactory("paginaWebPU");
   
    }
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Espectador espectador) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(espectador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEspectador(espectador.getNick()) != null) {
                throw new PreexistingEntityException("Espectador " + espectador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Espectador espectador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            espectador = em.merge(espectador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = espectador.getNick();
                if (findEspectador(id) == null) {
                    throw new NonexistentEntityException("The espectador with id " + id + " no longer exists.");
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
            Espectador espectador;
            try {
                espectador = em.getReference(Espectador.class, id);
                espectador.getNick();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The espectador with id " + id + " no longer exists.", enfe);
            }
            em.remove(espectador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Espectador> findEspectadorEntities() {
        return findEspectadorEntities(true, -1, -1);
    }

    public List<Espectador> findEspectadorEntities(int maxResults, int firstResult) {
        return findEspectadorEntities(false, maxResults, firstResult);
    }

    private List<Espectador> findEspectadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Espectador.class));
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

    public Espectador findEspectador(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Espectador.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspectadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Espectador> rt = cq.from(Espectador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void eliminarRegisto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
