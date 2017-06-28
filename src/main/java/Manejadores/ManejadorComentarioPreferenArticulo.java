package Manejadores;

import Logica.ComentarioPreferenciaArti;

import javax.persistence.EntityManager;

/**
 * Created by jrdis on 16/6/2017.
 */
public class ManejadorComentarioPreferenArticulo extends ManejadorDB<ComentarioPreferenciaArti> {
    private static ManejadorComentarioPreferenArticulo instance;

    private ManejadorComentarioPreferenArticulo() { super(ComentarioPreferenciaArti.class); }

    public static ManejadorComentarioPreferenArticulo getInstance() {
        if (instance == null) {
            instance = new ManejadorComentarioPreferenArticulo();
        }
        return instance;
    }

    public ComentarioPreferenciaArti getByUserComment(int userId, int commentId){
        EntityManager em = getEntityManager();
        try {
            return (ComentarioPreferenciaArti) em.createNamedQuery(ComentarioPreferenciaArti.getLikeDisByUserComment)
                    .setParameter("usuarioId",userId)
                    .setParameter("comentarioalbumId",commentId)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }
}
