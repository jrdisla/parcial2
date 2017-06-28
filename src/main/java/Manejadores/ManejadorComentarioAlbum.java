package Manejadores;

import Logica.ComentarioAlbum;
import Logica.ComentarioArticulo;

import javax.persistence.EntityManager;

/**
 * Created by jrdis on 16/6/2017.
 */
public class ManejadorComentarioAlbum extends ManejadorDB <ComentarioAlbum>  {

    private static ManejadorComentarioAlbum instance;

    private ManejadorComentarioAlbum() { super(ComentarioAlbum.class); }

    public static ManejadorComentarioAlbum getInstance() {
        if (instance == null) {
            instance = new ManejadorComentarioAlbum();
        }
        return instance;
    }

    public int deleteCommentById(int id) {
        int success = 0;
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            success = em.createNamedQuery(ComentarioAlbum.deleteCommentById)
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
