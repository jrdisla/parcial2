package Manejadores;

import Logica.Usuario;

import javax.persistence.EntityManager;

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

    public Usuario getUserBuUP(String username,String password) {
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
