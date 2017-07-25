package Soap;

import Logica.Articulo;
import Logica.Usuario;
import Manejadores.ManejadorArticulo;
import Manejadores.ManejadorUsuario;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesarjose on 7/25/17.
 */
@WebService
public class PostServicesSoap {

    /*@WebMethod
    public List<Articulo> getAllArticulos(String username)
    {
        Usuario usuario = ManejadorUsuario.getInstance().GetUser(username);
        List<Articulo> ans = new ArrayList<Articulo>(usuario.getArticulos());
        return ans;
    }
    */
    @WebMethod
    public List<String> getAllArticulo (String username) throws Exception {

        List<Articulo> articulos = ManejadorArticulo.getInstance().getAllObjects();
        List<String> list = new ArrayList<>();

        for (Articulo item: articulos)
        {
            if(item != null && item.getUsuario().getEmail().equalsIgnoreCase(username))
            {
                list.add(item.getTitulo());
                list.add(item.getBody());
            }
        }

        return list;
    }
}
