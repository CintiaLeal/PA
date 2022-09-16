/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Categoria;
import Logica.Espectaculo;
import Logica.Espectaculo_Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author romil
 */
public class Espectaculo_CategoriaJpaController implements Serializable {

    public Espectaculo_CategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Espectaculo_CategoriaJpaController() {
        emf = Persistence.createEntityManagerFactory("paginaWebPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Espectaculo_Categoria espectaculo_Categoria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria cat = espectaculo_Categoria.getCat();
            if (cat != null) {
                cat = em.getReference(cat.getClass(), cat.getNombre());
                espectaculo_Categoria.setCat(cat);
            }
            Espectaculo e = espectaculo_Categoria.getE();
            if (e != null) {
                e = em.getReference(e.getClass(), e.getNombre());
                espectaculo_Categoria.setE(e);
            }
            em.persist(espectaculo_Categoria);
            if (cat != null) {
                cat.getEspectaculos().add(espectaculo_Categoria);
                cat = em.merge(cat);
            }
            if (e != null) {
                e.getCategorias().add(espectaculo_Categoria);
                e = em.merge(e);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEspectaculo_Categoria(espectaculo_Categoria.getId_espectaculo()) != null) {
                throw new PreexistingEntityException("Espectaculo_Categoria " + espectaculo_Categoria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Espectaculo_Categoria espectaculo_Categoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Espectaculo_Categoria persistentEspectaculo_Categoria = em.find(Espectaculo_Categoria.class, espectaculo_Categoria.getId_espectaculo());
            Categoria catOld = persistentEspectaculo_Categoria.getCat();
            Categoria catNew = espectaculo_Categoria.getCat();
            Espectaculo eOld = persistentEspectaculo_Categoria.getE();
            Espectaculo eNew = espectaculo_Categoria.getE();
            if (catNew != null) {
                catNew = em.getReference(catNew.getClass(), catNew.getNombre());
                espectaculo_Categoria.setCat(catNew);
            }
            if (eNew != null) {
                eNew = em.getReference(eNew.getClass(), eNew.getNombre());
                espectaculo_Categoria.setE(eNew);
            }
            espectaculo_Categoria = em.merge(espectaculo_Categoria);
            if (catOld != null && !catOld.equals(catNew)) {
                catOld.getEspectaculos().remove(espectaculo_Categoria);
                catOld = em.merge(catOld);
            }
            if (catNew != null && !catNew.equals(catOld)) {
                catNew.getEspectaculos().add(espectaculo_Categoria);
                catNew = em.merge(catNew);
            }
            if (eOld != null && !eOld.equals(eNew)) {
                eOld.getCategorias().remove(espectaculo_Categoria);
                eOld = em.merge(eOld);
            }
            if (eNew != null && !eNew.equals(eOld)) {
                eNew.getCategorias().add(espectaculo_Categoria);
                eNew = em.merge(eNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = espectaculo_Categoria.getId_espectaculo();
                if (findEspectaculo_Categoria(id) == null) {
                    throw new NonexistentEntityException("The espectaculo_Categoria with id " + id + " no longer exists.");
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
            Espectaculo_Categoria espectaculo_Categoria;
            try {
                espectaculo_Categoria = em.getReference(Espectaculo_Categoria.class, id);
                espectaculo_Categoria.getId_espectaculo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The espectaculo_Categoria with id " + id + " no longer exists.", enfe);
            }
            Categoria cat = espectaculo_Categoria.getCat();
            if (cat != null) {
                cat.getEspectaculos().remove(espectaculo_Categoria);
                cat = em.merge(cat);
            }
            Espectaculo e = espectaculo_Categoria.getE();
            if (e != null) {
                e.getCategorias().remove(espectaculo_Categoria);
                e = em.merge(e);
            }
            em.remove(espectaculo_Categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Espectaculo_Categoria> findEspectaculo_CategoriaEntities() {
        return findEspectaculo_CategoriaEntities(true, -1, -1);
    }

    public List<Espectaculo_Categoria> findEspectaculo_CategoriaEntities(int maxResults, int firstResult) {
        return findEspectaculo_CategoriaEntities(false, maxResults, firstResult);
    }

    private List<Espectaculo_Categoria> findEspectaculo_CategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Espectaculo_Categoria.class));
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

    public Espectaculo_Categoria findEspectaculo_Categoria(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Espectaculo_Categoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspectaculo_CategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Espectaculo_Categoria> rt = cq.from(Espectaculo_Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
