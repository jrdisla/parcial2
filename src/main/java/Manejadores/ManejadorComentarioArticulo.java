package Manejadores;

import Logica.ComentarioArticulo;

import javax.persistence.EntityManager;

/**
 * Created by jrdis on 16/6/2017.
 */
public class ManejadorComentarioArticulo extends ManejadorDB<ComentarioArticulo> {

    private static ManejadorComentarioArticulo instance;

    private ManejadorComentarioArticulo() { super(ComentarioArticulo.class); }

    public static ManejadorComentarioArticulo getInstance() {
        if (instance == null) {
            instance = new ManejadorComentarioArticulo();
        }
        return instance;
    }

    public int deleteCommentById(int id) {
        int success = 0;
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            success = em.createNamedQuery(ComentarioArticulo.deleteCommentById)
                    .setParameter("id", id)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            success = 0;
            e.printStackTrace();
        } finally {
            em.close();
            return success;
        }
    }
}
