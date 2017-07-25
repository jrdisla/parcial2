import Client_Soap.StartSoap;
import Logica.Usuario;
import Manejadores.ManejadorUsuario;
import Soap.SoapArranque;
import org.h2.tools.Server;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by jrdis on 16/6/2017.
 */
public class Main {

    public static File uploadDir = new File("./src/main/resources/templates/temp/uploads");
    public static File DowDir = new File("./src/main/resources/public/do");
    public static void main(String[] args) throws Exception {

        //Usuario usuario = new Usuario("admin@admin", "admin", "admin", true, "admin");
        //ManejadorUsuario manejadorUsuario = ManejadorUsuario.getInstance();
        //manejadorUsuario.insertIntoDatabase(usuario);

        Usuario user = new Usuario("cliente@gmail.com","admin","admin",true,"admin");
        ManejadorUsuario.getInstance().insertIntoDatabase(user);

        try
        {
            Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        uploadDir.createNewFile();
        DowDir.createNewFile();
        Rutas.StartProyect(uploadDir,DowDir);

      //  StartSoap.Run();
       // SoapArranque.init();

    }
}
