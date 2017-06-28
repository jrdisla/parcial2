package Manejadores;

import Logica.ArticuloPreferencia;
import Logica.ComentarioPreferenciaArti;

import javax.persistence.EntityManager;

/**
 * Created by jrdis on 16/6/2017.
 */
public class ManejadorArticuloPreferencia extends ManejadorDB <ArticuloPreferencia>{
    private static ManejadorArticuloPreferencia instance;

    private ManejadorArticuloPreferencia() { super(ArticuloPreferencia.class); }

    public static ManejadorArticuloPreferencia getInstance() {
        if (instance == null) {
            instance = new ManejadorArticuloPreferencia();
        }
        return instance;
    }

    public ArticuloPreferencia getByUserComment(int userId, int commentId){
        EntityManager em = getEntityManager();
        try {
            return (ArticuloPreferencia) em.createNamedQuery(ArticuloPreferencia.getLikeDis)
                    .setParameter("userId",userId)
                    .setParameter("articleId",commentId)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }
}
