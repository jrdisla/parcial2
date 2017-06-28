package Manejadores;

import Logica.AlbumPreferencia;
import Logica.ArticuloPreferencia;
import Logica.ComentarioPreferenciaArti;

import javax.persistence.EntityManager;

/**
 * Created by jrdis on 16/6/2017.
 */
public class ManejadorAlbumPreferencia extends ManejadorDB<AlbumPreferencia> {
    private static ManejadorAlbumPreferencia instance;

    private ManejadorAlbumPreferencia() { super(AlbumPreferencia.class); }

    public static ManejadorAlbumPreferencia getInstance() {
        if (instance == null) {
            instance = new ManejadorAlbumPreferencia();
        }
        return instance;
    }

    public AlbumPreferencia getByUserComment(int userId, int commentId){
        EntityManager em = getEntityManager();
        try {
            return (AlbumPreferencia) em.createNamedQuery(AlbumPreferencia.getLikeDis)
                    .setParameter("userId",userId)
                    .setParameter("albumId",commentId)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }
}
