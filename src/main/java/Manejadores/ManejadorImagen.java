package Manejadores;

import Logica.Imagenes;
import Logica.Usuario;

import javax.persistence.EntityManager;

/**
 * Created by jrdis on 16/6/2017.
 */
public class ManejadorImagen extends ManejadorDB<Imagenes> {
    private static ManejadorImagen instance;

    private ManejadorImagen() { super(Imagenes.class); }

    public static ManejadorImagen getInstance() {
        if (instance == null) {
            instance = new ManejadorImagen();
        }
        return instance;
    }

    public Usuario getImagenBuUP(String username,String password) {
        EntityManager em = getEntityManager();
        try {
            return (Usuario) em.createNamedQuery(Usuario.chekUserPassword)
                    .setParameter("email",username)
                    .setParameter("contraseñ",password)
                    .getSingleResult();
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
}
