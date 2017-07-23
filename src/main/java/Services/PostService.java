package Services;

import Logica.Articulo;
import Logica.Usuario;
import Manejadores.ManejadorUsuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by cesarjose on 7/23/17.
 */
public class PostService {

    private static PostService instancia;
    private static List<Articulo> articuloList;

    private PostService()
    {
        articuloList = new ArrayList<Articulo>();
    }

    public static PostService getInstancia()
    {
        if(instancia==null)
        {
            instancia = new PostService();
        }

        return instancia;
    }

    public Usuario getUsuario(String email) throws Exception{

        List<Usuario> usuarioList = ManejadorUsuario.getInstance().getAllObjects();
        System.out.println(usuarioList.size());
        return usuarioList.get(0);
        //return usuarioList.stream().filter(est -> est.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }

    public List<Articulo> getAllArticulos(String username)
    {
        Usuario usuario = ManejadorUsuario.getInstance().GetUser(username);
        System.out.println(usuario.getNombre() + " " + usuario.getApellido());

        List<Articulo> ans = new ArrayList<Articulo>(usuario.getArticulos());

        System.out.println(ans.size());
        return ans;
    }
}
