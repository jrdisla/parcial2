package Manejadores;

import Logica.Album;
import Logica.Articulo;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by jrdis on 16/6/2017.
 */
public class ManejadorAlbum extends ManejadorDB<Album> {
    private static ManejadorAlbum instance;

    private ManejadorAlbum() { super(Album.class); }

    public static ManejadorAlbum getInstance() {
        if (instance == null) {
            instance = new ManejadorAlbum();
        }
        return instance;
    }

    public Album getByEmail(String title){
        EntityManager em = getEntityManager();
        try {
            return (Album) em.createNamedQuery(Album.by_title)
                    .setParameter("email",title)
                    .getSingleResult();
        } catch (Exception ex) {
            throw ex;
        } finally {
            em.close();
        }
    }


    public List<Album> pagination(int limit, int offset) {
        EntityManager em = getEntityManager();
        try {
            return (List<Album>) em.createNamedQuery(Album.pag)
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
