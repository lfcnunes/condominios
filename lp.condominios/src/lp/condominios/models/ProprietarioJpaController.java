/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.condominios.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lp.condominios.models.exceptions.NonexistentEntityException;
import lp.condominios.models.exceptions.PreexistingEntityException;

/**
 *
 * @author Pedro
 */
public class ProprietarioJpaController implements Serializable {

    public ProprietarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proprietario proprietario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(proprietario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProprietario(proprietario.getId()) != null) {
                throw new PreexistingEntityException("Proprietario " + proprietario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proprietario proprietario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            proprietario = em.merge(proprietario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = proprietario.getId();
                if (findProprietario(id) == null) {
                    throw new NonexistentEntityException("The proprietario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proprietario proprietario;
            try {
                proprietario = em.getReference(Proprietario.class, id);
                proprietario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proprietario with id " + id + " no longer exists.", enfe);
            }
            em.remove(proprietario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proprietario> findProprietarioEntities() {
        return findProprietarioEntities(true, -1, -1);
    }

    public List<Proprietario> findProprietarioEntities(int maxResults, int firstResult) {
        return findProprietarioEntities(false, maxResults, firstResult);
    }

    private List<Proprietario> findProprietarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proprietario.class));
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

    public Proprietario findProprietario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proprietario.class, id);
        } finally {
            em.close();
        }
    }

    public int getProprietarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proprietario> rt = cq.from(Proprietario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
