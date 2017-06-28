package Manejadores;

import Logica.Articulo;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by jrdis on 16/6/2017.
 */
public class ManejadorArticulo extends ManejadorDB<Articulo> {
    private static ManejadorArticulo instance;

    private ManejadorArticulo() { super(Articulo.class); }

    public static ManejadorArticulo getInstance() {
        if (instance == null) {
            instance = new ManejadorArticulo();
        }
        return instance;
    }

    public Articulo getByTitle(String title){
        EntityManager em = getEntityManager();
        try {
            return (Articulo) em.createNamedQuery(Articulo.by_title)
                    .setParameter("titulo",title)
                    .getSingleResult();
        } catch (Exception ex) {
            throw ex;
        } finally {
            em.close();
        }
    }


    public List<Articulo> pagination(int limit, int offset) {
        EntityManager em = getEntityManager();
        try {
            return (List<Articulo>) em.createNamedQuery(Articulo.pag)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList();
        } catch (Exception ex) {
            throw ex;
        } finally {
            em.close();
        }
    }

}
