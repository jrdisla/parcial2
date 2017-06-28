package Manejadores;

import Logica.ComentarioAlbumPrefe;
import Logica.ComentarioPreferenciaArti;

import javax.persistence.EntityManager;

/**
 * Created by jrdis on 16/6/2017.
 */
public class ManejadorComentarioAlbumPreferenci extends ManejadorDB<ComentarioAlbumPrefe> {
    private static ManejadorComentarioAlbumPreferenci instance;

    private ManejadorComentarioAlbumPreferenci() { super(ComentarioAlbumPrefe.class); }

    public static ManejadorComentarioAlbumPreferenci getInstance() {
        if (instance == null) {
            instance = new ManejadorComentarioAlbumPreferenci();
        }
        return instance;
    }

    public ComentarioAlbumPrefe getByUserComment(int userId, int commentId){
        EntityManager em = getEntityManager();
        try {
            return (ComentarioAlbumPrefe) em.createNamedQuery(ComentarioAlbumPrefe.getLikeDisByUserComment)
                    .setParameter("userId",userId)
                    .setParameter("commentId",commentId)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }
}
