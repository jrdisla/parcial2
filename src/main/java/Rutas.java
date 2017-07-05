/**
 * Created by cesarjose on 6/29/17.
 */

import Logica.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import Manejadores.*;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.Spark;

import javax.swing.*;
import java.io.File;
import java.io.StringWriter;
import java.nio.file.Files;
import java.util.*;
import java.util.jar.Attributes;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;


public class Rutas {

        public static void StartProyect() {

            staticFiles.location("templates");
            final Configuration configuration = new Configuration(new Version(2, 3, 0));
            configuration.setClassForTemplateLoading(Rutas.class, "/");
            //enableDebugScreen();

            Spark.get("/Login", (request, response) -> {


                Template resultTemplate = configuration.getTemplate("templates/Login.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();

                resultTemplate.process(attributes, writer);
                return writer;
            });


            Spark.post("/loginProcess", (request, response) -> {

                Session session = request.session(true);
                String username = request.queryParams("username");
                String password = request.queryParams("password");

                ManejadorUsuario userHandler = ManejadorUsuario.getInstance();
                Usuario usuario = userHandler.GetUser(username);

                if (usuario != null && usuario.getContraseña().equalsIgnoreCase(password))
                {
                    session.attribute("username",usuario);
                    response.redirect("/profile");
                }
                else
                {
                    response.redirect("/home");
                }
                return "";
            });

            Spark.get("/profile", (request, response) -> {

                Template resultTemplate = configuration.getTemplate("templates/profile.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();

                Usuario usuario = request.session().attribute("username");

                attributes.put("user",usuario);
                resultTemplate.process(attributes, writer);
                return writer;
            });

            Spark.get("/index", (request, response) -> {

                Template resultTemplate = configuration.getTemplate("templates/index.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();

                Usuario usuario = request.session().attribute("username");

                attributes.put("user",usuario);
                resultTemplate.process(attributes, writer);
                return writer;
            });

            Spark.post("/addUser", (request, response) -> {

                Template resultTemplate = configuration.getTemplate("templates/index.ftl");
                StringWriter writer = new StringWriter();

                String name = request.queryParams("firstname");
                String lastname = request.queryParams("lastname");
                String email = request.queryParams("email");
                String countrie = request.queryParams("countrie");
                String city = request.queryParams("city");
                String language = request.queryParams("language");
                String date_b = request.queryParams("date_b");
                String password = request.queryParams("password");

                Date publishedDate = new Date();
                String[] birthday = date_b.split("-");

                int day = Integer.parseInt(birthday[2]);
                int month = Integer.parseInt(birthday[1]);
                int year = Integer.parseInt(birthday[0]);

                year -=1900;
                month-=1;

                Date date_bir = new Date(year,month,day);

                Usuario user = new Usuario(email, name, lastname, "masculino", date_bir, countrie, city,publishedDate, language, password);

                if(ManejadorUsuario.getInstance().GetUser(user.getEmail()) == null)
                {
                    ManejadorUsuario.getInstance().insertIntoDatabase(user);
                    Session session = request.session(true);
                    session.attribute("username",user);
                }

                Map<String, Object> attributes = new HashMap<>();
                attributes.put("user",user);
                resultTemplate.process(attributes, writer);
                return writer;
            });

            Spark.get("/home", (request, response) -> {

                Template resultTemplate = configuration.getTemplate("templates/register.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();

                resultTemplate.process(attributes, writer);
                return writer;
            });




            before("/profile",(request, response) -> {
                autorizado(request,response);
            });

            before("/index",(request, response) -> {
                autorizado(request,response);
            });
        }

        private static void autorizado(Request request, Response response) {

        Session ses = request.session(true);
        Usuario user = ses.attribute("username");

        if(user == null)
        {
            halt(401, "No Autorizado");
        }
    }
}

