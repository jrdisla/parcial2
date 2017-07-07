package Manejadores;

import Logica.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by jrdis on 16/6/2017.
 */
public class ManejadorUsuario extends ManejadorDB<Usuario> {
    private static ManejadorUsuario instance;

    private ManejadorUsuario() { super(Usuario.class); }

    public static ManejadorUsuario getInstance() {
        if (instance == null) {
            instance = new ManejadorUsuario();
        }
        return instance;
    }

    public List<Usuario> getUserBuUP(String lugar_naci, String ciudad) {
        EntityManager em = getEntityManager();
        try {
            return (List<Usuario>) em.createNamedQuery(Usuario.chekUserPassword)
                    .setParameter("lugar_naci",lugar_naci)
                    .setParameter("ciudad",ciudad)
                    .getResultList();
        }  finally {
            em.close();
        }
    }

    public Usuario GetUser(String username)  {
        EntityManager em = getEntityManager();
        try {
            return (Usuario) em.createNamedQuery(Usuario.getUser)
                    .setParameter("email", username)
                    .getSingleResult();
        }
        catch (Exception ex) {
            return null;
        }
        finally {
            em.close();
        }
    }

    public List<Usuario> getAllUsers()
    {
        EntityManager em = getEntityManager();
        try {
            return (List<Usuario>) em.createNamedQuery(Usuario.getAllUsers).getResultList();
        }  finally {
            em.close();
        }
    }
}
