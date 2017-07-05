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
import spark.utils.IOUtils;
import sun.util.calendar.BaseCalendar;

import javax.imageio.ImageIO;
import javax.servlet.MultipartConfigElement;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.jar.Attributes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;


public class Rutas {


    public static void StartProyect(File upload, File Do) {
         File uploadDir = new File("/resources/public/uploads");
            staticFiles.location("templates");
            final Configuration configuration = new Configuration(new Version(2, 3, 0));
            configuration.setClassForTemplateLoading(Rutas.class, "/");
            enableDebugScreen();

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

            Spark.get("/moreDataUser", (request, response) -> {

                Template resultTemplate = configuration.getTemplate("templates/moreDataUser.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();

                Usuario usuario = request.session().attribute("username");

                attributes.put("user",usuario);
                resultTemplate.process(attributes, writer);
                return writer;
            });

            Spark.get("/addProfilePicture", (request, response) -> {

                Template resultTemplate = configuration.getTemplate("templates/addProfilePicture.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();

                Usuario usuario = request.session().attribute("username");

                attributes.put("user",usuario);
                resultTemplate.process(attributes, writer);
                return writer;
            });

            Spark.post("/addUser", (request, response) -> {

                String name = request.queryParams("firstname");
                String lastname = request.queryParams("lastname");
                String email = request.queryParams("email");
                String country = request.queryParams("countries");
                String city = request.queryParams("city");
                String language = request.queryParams("languages");
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

                Usuario user = new Usuario(email, name, lastname, date_bir, country, city,publishedDate, language, password);

                if(ManejadorUsuario.getInstance().GetUser(user.getEmail()) == null)
                {
                    ManejadorUsuario.getInstance().insertIntoDatabase(user);
                }

                Session session = request.session(true);
                session.attribute("username",user);
                response.redirect("/moreDataUser");
                return "";
            });

            Spark.post("/addUserPart2",(request, response) -> {

                Session session = request.session(true);
                Usuario usuario = session.attribute("username");

                String igAccount = request.queryParams("ig");
                String lugarEstudio = request.queryParams("estudios");
                String sexo = request.queryParams("sex");
                String descripcion = request.queryParams("description");


                usuario.setIg_cuenta(igAccount);
                usuario.setLugares_estudio(lugarEstudio);
                usuario.setSexo(sexo);
                usuario.setDescripcion(descripcion);

                ManejadorUsuario.getInstance().updateObject(usuario);

                session.attribute("username",usuario);
                response.redirect("/addProfilePicture");

                return "";
            });

            Spark.post("/addPicture",(request, response) -> {

                Session session = request.session(true);
                Usuario usuario = session.attribute("username");

                String profileImage = request.queryParams("images");
                byte[] image = profileImage.getBytes();
                usuario.setFoto_perfil(image);

                ManejadorUsuario.getInstance().updateObject(usuario);

                session.attribute("username",usuario);
                response.redirect("/profile");

                return "";
            });

            Spark.post("/addText",(request, response) -> {

                Session session = request.session(true);
                Usuario usuario = session.attribute("username");

                String text = request.queryParams("opinion");
                Articulo articulo = new Articulo();
                articulo.setBody(text);
                articulo.setUsuario(usuario);

                Set<Articulo> articulos = usuario.getArticulos();
                articulos.add(articulo);

                usuario.setArticulos(articulos);
                ManejadorUsuario.getInstance().updateObject(usuario);

                response.redirect("/profile");

                return "";
            });

            Spark.get("/register", (request, response) -> {

                Template resultTemplate = configuration.getTemplate("templates/register.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();

                resultTemplate.process(attributes, writer);
                return writer;
            });

            before("/home",(request, response) -> {
                System.out.println(request.contentType());
            });
            Spark.get("/home", (request, response) -> {

                Template resultTemplate = configuration.getTemplate("templates/test.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();

                resultTemplate.process(attributes, writer);
                return writer;
            });

            Spark.post("/file", (request, response) -> {
                String aver = request.params("image-url");
                System.out.println("Esto es: " + aver);
                Date nowDate = new Date();
                String file_name = "img_exampple" ;

                Path temp = Paths.get(upload.getAbsolutePath() + file_name+".jpeg");
                request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

                try (InputStream input = request.raw().getPart("image-file").getInputStream()) {

                    File file = null;

                    Files.copy(input, temp, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Tamano de image: " +temp.toFile().length());

                    file = temp.toFile();
                    System.out.println(input.toString());
                    byte [] byteP ;
                    byteP = Files.readAllBytes(temp);


                    System.out.println("Tamano de bytes: "+ byteP.length);
                    System.out.println(Arrays.toString(byteP));
                    FileOutputStream fileOutputStream = new FileOutputStream("./src/main/resources/public/do.jpeg");
                    fileOutputStream.write(byteP);
                    fileOutputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }



              //  Template resultTemplate = configuration.getTemplate("templates/test.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();
                System.out.println("llego");
             //   resultTemplate.process(attributes, writer);
                return writer;
            });

            Spark.get("/logout",(request, response) -> {

                Session session = request.session(true);
                session.invalidate();

                response.redirect("/Login");
                return "";
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
    private static String convertStreamToString(InputStream input) {
        Scanner scanner = new Scanner(input).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }
    public static byte[] readFully(InputStream input, int sise) throws IOException
    {
        byte[] buffer = new byte[sise];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        while ((bytesRead = input.read(buffer)) != -1)
        {
            output.write(buffer, 0, bytesRead);
        }
        return output.toByteArray();
    }
}

