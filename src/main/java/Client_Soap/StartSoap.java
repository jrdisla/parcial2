package Client_Soap;

import Logica.*;
import Services.PostService;
import Utilidades.JsonUtilidades;
import com.google.gson.Gson;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import Manejadores.*;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.Spark;
import javax.servlet.MultipartConfigElement;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Created by cesarjose on 7/25/17.
 */
public class StartSoap {

    public static void Run()
    {
        port(4568);
        staticFiles.location("templates");
        staticFiles.externalLocation(System.getProperty("java.io.tmpdir"));
        final Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(StartSoap.class, "/");

        enableDebugScreen();

        Spark.get("/Client", (request, response) -> {

            Template resultTemplate = configuration.getTemplate("templates/Clientes/Soap-index.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();

            resultTemplate.process(attributes, writer);
            return writer;
        });

    }


}
