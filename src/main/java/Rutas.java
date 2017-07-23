/**
 * Created by cesarjose on 6/29/17.
 */

import Logica.*;
import Services.PostService;
import com.google.gson.Gson;
import Utilidades.JsonUtilidades;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import Manejadores.*;
import javafx.geometry.Pos;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.Spark;
import javax.servlet.MultipartConfigElement;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;


public class Rutas {

    public final static String ACCEPT_TYPE = "application/json";

    public static void StartProyect(File upload, File Do) {

        staticFiles.location("templates");
        staticFiles.externalLocation(System.getProperty("java.io.tmpdir"));
        final Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(Rutas.class, "/");


        enableDebugScreen();

        path("/rest", () -> {
            //filtros especificos:
           /* afterAfter("/*", (request, response) -> { //indicando que todas las llamadas retorna un json.
                response.header("Content-Type", ACCEPT_TYPE);
            });
            */
            //rutas del api
            path("/post", () -> {

                get("/", (request, response) -> {
                    //return PostService.getInstancia().getUsuario("twindark1@gmail.com");
                    return PostService.getInstancia().getAllArticulos("twindark1@gmail.com");
                }, JsonUtilidades.json());

                //retorna los articulos de un usuario
                Spark.get("/:email", (request, response) -> {
                    return PostService.getInstancia().getAllArticulos(request.params("email"));
                }, JsonUtilidades.json());

                /*
                //crea un estudiante
                Spark.post("/", Main.ACCEPT_TYPE, (request, response) -> {
                    Estudiante estudiante = new Gson().fromJson(request.body(), Estudiante.class);
                    return PostService.crearEstudiante(estudiante);
                }, JsonUtilidades.json());
                */
            });
        });

        Spark.get("/", (request, response) -> {

            Session session = request.session(true);
            Usuario usuario = session.attribute("username");

            if(usuario != null)
                response.redirect("/profile");

            else
                response.redirect("/Login");

            return "";
        });

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

            if (usuario != null && usuario.getContraseña().equalsIgnoreCase(password)) {
                session.attribute("username", usuario);
                response.redirect("/profile");
            } else {
                response.redirect("/Login");
            }
            return "";
        });

        Spark.get("/profile", (request, response) -> {
            Usuario usuario = request.session().attribute("username");
            Template resultTemplate = configuration.getTemplate("templates/profile.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();
            List<Articulo> articulos = new ArrayList<>();

               /* for (Articulo item:usuario.getArticulos() )
                {
                    if(item.getBody() == null)
                    {
                        item.setBody("HOLA");
                    }
                    articulos.add(item);
                }*/

            Imagenes imagenes = usuario.getFoto_perfil();
            List<Amigos> amigos = new ArrayList<>();
            List<String> paths = new ArrayList<>();
            for (Amigos item : usuario.getAmigos()
                    ) {
                amigos.add(item);
            }


            for (Articulo item : articulos
                    ) {
                System.out.println(item.getBody());
            }
            String path = imagenes.getPath();
            attributes.put("ver", usuario.getFoto_perfil().getPath());
            attributes.put("user", usuario);
            attributes.put("image", amigos);
            attributes.put("articulo", articulos);
            resultTemplate.process(attributes, writer);
            return writer;
        });
        Spark.get("/ver/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            Template resultTemplate = configuration.getTemplate("templates/profile.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();
            Usuario user = request.session().attribute("username");
            Usuario usuario = ManejadorUsuario.getInstance().findObjectWithId(id);
            Imagenes imagenes = usuario.getFoto_perfil();
            List<Amigos> amigos = new ArrayList<>();
            List<String> paths = new ArrayList<>();
            for (Amigos item : usuario.getAmigos()
                    ) {
                paths.add(item.getUsuario().getFoto_perfil().getPath());
            }

            String path = imagenes.getPath();
            attributes.put("ver", "/temp/" + path);
            attributes.put("user", usuario);
            attributes.put("image", paths);
            resultTemplate.process(attributes, writer);
            return modelAndView(attributes, "profile.ftl");
        });
        Spark.get("/index", (request, response) -> {
            Usuario usuario = request.session().attribute("username");
            Template resultTemplate = configuration.getTemplate("templates/index.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();
            List<Articulo> articulos = new ArrayList<>();
            List<Amigos> amigos = new ArrayList<>();
          /*      for (Articulo item: usuario.getArticulos()
                     ) {
                    articulos.add(item);

                }
                for (Amigos item: usuario.getAmigos())
                {
                    for (Articulo item2: item.getUsuario().getArticulos())
                    {
                        articulos.add(item2);
                    }
                }*/

            articulos = ManejadorArticulo.getInstance().getAllObjects();


            attributes.put("user", usuario);

            attributes.put("articulos", articulos);
            resultTemplate.process(attributes, writer);
            return writer;
        });

        Spark.get("/articulo/valida/:id", (request, response) -> {

            String id = request.params(":id");
            int id_ = Integer.parseInt(id);

            Usuario user = request.session().attribute("username");
            String comment = request.queryParams("comment");

            ComentarioArticulo comentarioArticulo = new ComentarioArticulo();
            comentarioArticulo.setBody(comment);
            Articulo arti_c = ManejadorArticulo.getInstance().findObjectWithId(id_);
            comentarioArticulo.setArticulo(arti_c);
            comentarioArticulo.setUser(user);
            ManejadorComentarioArticulo.getInstance().insertIntoDatabase(comentarioArticulo);
            arti_c.getComentarioArticulo().add(comentarioArticulo);
            ManejadorArticulo.getInstance().updateObject(arti_c);

            response.redirect("/index");
            return "";
        });


        Spark.get("/moreDataUser", (request, response) -> {

            Template resultTemplate = configuration.getTemplate("templates/moreDataUser.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();

            Usuario usuario = request.session().attribute("username");

            attributes.put("user", usuario);
            resultTemplate.process(attributes, writer);
            return writer;
        });

        Spark.get("/photos", (request, response) -> {

            Template resultTemplate = configuration.getTemplate("templates/photos.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();

            Usuario usuario = request.session().attribute("username");

            attributes.put("user", usuario);
            resultTemplate.process(attributes, writer);
            return writer;
        });

        Spark.get("/addProfilePicture", (request, response) -> {

            Template resultTemplate = configuration.getTemplate("templates/addProfilePicture.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();

            Usuario usuario = request.session().attribute("username");

            attributes.put("user", usuario);
            resultTemplate.process(attributes, writer);
            return writer;
        });

        Spark.get("/zonaAdmin", (request, response) -> {

            Template resultTemplate = configuration.getTemplate("templates/zonaAdmin.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();

            Usuario usuario = request.session().attribute("username");

            attributes.put("user", usuario);
            resultTemplate.process(attributes, writer);
            return writer;
        });

        Spark.get("/preferences/likes/:id/:arti", (request, response) -> {

            int id = Integer.parseInt(request.params(":id"));

            Usuario user = request.session().attribute("username");
            int id_c = Integer.parseInt(request.params(":arti"));
            Articulo article = ManejadorArticulo.getInstance().findObjectWithId(id_c);

            if (id == 1) {

                ArticuloPreferencia articleLikes = new ArticuloPreferencia(user, article, "LIKE");
                ArticuloPreferencia item = ManejadorArticuloPreferencia.getInstance().getItByArtiUser(user.getId(), article.getId());

                if (item != null) {
                    if (item.getPreferencia().substring(0, 3).equalsIgnoreCase("DIS")) {

                        int ida = item.getId();
                        System.out.println(item.getId());
                        ManejadorArticuloPreferencia.getInstance().deleteObjectWithId(ida);
                        articleLikes.setPreferencia("LIKE");

                        int likes = article.getCount_();
                        likes++;
                        article.setCount_(likes);
                        ManejadorArticuloPreferencia.getInstance().insertIntoDatabase(articleLikes);
                        int disl = article.getDislike();
                        if (disl > 0) {
                            disl--;
                            article.setDislike(disl);
                        }
                        ManejadorArticulo.getInstance().updateObject(article);

                    } else {
                        int id_a = item.getId();
                        ManejadorArticuloPreferencia.getInstance().deleteObjectWithId(id_a);
                        int like = article.getCount_();
                        if (like > 0) {
                            like--;
                            article.setCount_(like);
                        }
                        ManejadorArticulo.getInstance().updateObject(article);
                        response.redirect("/index");

                    }
                } else {

                    ManejadorArticuloPreferencia.getInstance().insertIntoDatabase(articleLikes);
                    int likes2 = article.getCount_();
                    if (likes2 == 0) {
                        likes2++;
                        article.setCount_(likes2);
                    } else {
                        int dislikes = article.getDislike();
                        dislikes--;
                        article.setDislike(dislikes);
                    }
                    ManejadorArticulo.getInstance().updateObject(article);

                }
            } else {

                ArticuloPreferencia articlePreference = new ArticuloPreferencia(user, article, "DISLIKE");
                ArticuloPreferencia item = ManejadorArticuloPreferencia.getInstance().getItByArtiUser(user.getId(), article.getId());

                if (item != null) {
                    if (item.getPreferencia().substring(0, 3).equalsIgnoreCase("LIK")) {

                        int ida = item.getId();
                        ManejadorArticuloPreferencia.getInstance().deleteObjectWithId(ida);
                        articlePreference.setPreferencia("DISLIKE");
                        int dislikes = article.getDislike();
                        dislikes++;
                        article.setDislike(dislikes);
                        ManejadorArticuloPreferencia.getInstance().insertIntoDatabase(articlePreference);

                        int disl = article.getCount_();
                        if (disl > 0) {
                            disl--;
                            article.setCount_(disl);
                        }

                        ManejadorArticulo.getInstance().updateObject(article);
                    } else {
                        int id_a = item.getId();
                        ManejadorArticuloPreferencia.getInstance().deleteObjectWithId(id_a);

                        int disl = article.getDislike();
                        if (disl > 0) {
                            disl--;
                            article.setDislike(disl);
                        }
                        ManejadorArticulo.getInstance().updateObject(article);
                        response.redirect("/index");
                    }
                } else {
                    ManejadorArticuloPreferencia.getInstance().insertIntoDatabase(articlePreference);
                    int dislikes = article.getDislike();
                    if (dislikes == 0) {
                        dislikes++;
                        article.setDislike(dislikes);
                    } else {
                        int likes = article.getCount_();
                        likes--;
                        article.setCount_(likes);
                    }
                    ManejadorArticulo.getInstance().updateObject(article);
                }

            }
            response.redirect("/index");
            return "";
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

            if(name.length() > 0 && lastname.length() > 0)
            {
                Date publishedDate = new Date();
                String[] birthday = date_b.split("-");

                int day = Integer.parseInt(birthday[2]);
                int month = Integer.parseInt(birthday[1]);
                int year = Integer.parseInt(birthday[0]);

                year -= 1900;
                month -= 1;

                Date date_bir = new Date(year, month, day);

                Usuario user = new Usuario(email, name, lastname, date_bir, country, city, publishedDate, language, password);

                if (ManejadorUsuario.getInstance().GetUser(user.getEmail()) == null) {
                    ManejadorUsuario.getInstance().insertIntoDatabase(user);
                }

                Session session = request.session(true);
                session.attribute("username", user);
                response.redirect("/moreDataUser");
            }

            return "";
        });

        Spark.post("/addUserPart2", (request, response) -> {

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

            session.attribute("username", usuario);
            response.redirect("/addProfilePicture");

            return "";
        });

        Spark.post("/addPicture", (request, response) -> {

            Session session = request.session(true);
            Usuario usuario = session.attribute("username");

            String profileImage = request.queryParams("images");
            //  byte[] image = profileImage.getBytes();
            // usuario.setFoto_perfil(image);

            usuario.setEsAdmin(true);
            ManejadorUsuario.getInstance().updateObject(usuario);

            session.attribute("username", usuario);
            response.redirect("/profile");

            return "";
        });

        Spark.post("/photosUser", (request, response) -> {

            Usuario user = request.session().attribute("username");
            String aver = request.params("image-url");

            Date nowDate = new Date();
            String file_name = "img_example_" + user.getId() + nowDate.getSeconds() + (ManejadorImagen.getInstance().getAllObjects().size() + 1);

            Path temp = Paths.get(upload.getAbsolutePath() + file_name + ".jpeg");
            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

            try (InputStream input = request.raw().getPart("image-file").getInputStream()) {

                Files.copy(input, temp, StandardCopyOption.REPLACE_EXISTING);

                byte[] byteP;
                byteP = Files.readAllBytes(temp);

                Imagenes imagen = new Imagenes();

                imagen.setImagen(byteP);
                imagen.setPath(temp.getFileName().toString());

                ManejadorImagen.getInstance().insertIntoDatabase(imagen);
                ManejadorUsuario.getInstance().updateObject(user);
                FileOutputStream fileOutputStream = new FileOutputStream("./src/main/resources/public/do.jpeg");
                fileOutputStream.write(ManejadorImagen.getInstance().findObjectWithId(imagen.getId()).getImagen());
                // fileOutputStream.close();
                //   input.close();

            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }

            return "";
        });

        Spark.post("/addText", (request, response) -> {

            Session session = request.session(true);
            Usuario usuario = session.attribute("username");
            Articulo articulo = new Articulo();


            int size = usuario.getArticulos().size();
            articulo.setTitulo("Articulo " + (size + 1));
            usuario.getArticulos().add(articulo);

            Date nowDate = new Date();
            String file_name = "img_example_" + usuario.getId() + nowDate.getSeconds() + (ManejadorImagen.getInstance().getAllObjects().size() + 1);

            Path temp = Paths.get(upload.getAbsolutePath() + file_name + ".jpeg");
            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            File ima = new File(System.getProperty("java.io.tmpdir"));
            String text = getStringFromInputStream(request.raw().getPart("opinion_2").getInputStream());
            articulo.setBody(text);
            articulo.setUsuario(usuario);
            articulo.setFecha(new Date());
            try (InputStream input = request.raw().getPart("image-file").getInputStream()) {

                Files.copy(input, temp, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Tamano de image: " + temp.toFile().length());

                byte[] byteP;
                byteP = Files.readAllBytes(temp);
                File temp2 = File.createTempFile("image", "jpeg", ima);
                FileOutputStream fos = new FileOutputStream(temp2);
                fos.write(byteP);
                Imagenes imagen = new Imagenes();
                imagen.setImagen(byteP);
                imagen.setPath(temp2.getName());
                if (temp.toFile().length() > 0) {
                    articulo.setImagen(imagen);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
            ManejadorArticulo.getInstance().insertIntoDatabase(articulo);
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

        Spark.get("/home", (request, response) -> {

            Template resultTemplate = configuration.getTemplate("templates/test.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();
            Usuario user = request.session().attribute("username");

            Imagenes imagenes = user.getFoto_perfil();
            //  imagenes.getPath("uploadsimg_example_354508.jpeg");
            System.out.println(imagenes.getPath());
            attributes.put("ver", "/temp/" + imagenes.getPath());
            resultTemplate.process(attributes, writer);
            return writer;
        });

        Spark.post("/file", (request, response) -> {
            Usuario user = request.session().attribute("username");
            String aver = request.params("image-url");
            System.out.println("Esto es: " + aver);
            Date nowDate = new Date();
            String file_name = "img_example_" + user.getId() + nowDate.getSeconds() + (ManejadorImagen.getInstance().getAllObjects().size() + 1);

            Path temp = Paths.get(upload.getAbsolutePath() + file_name + ".jpeg");
            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            File ima = new File(System.getProperty("java.io.tmpdir"));
            try (InputStream input = request.raw().getPart("image-file").getInputStream()) {

                Files.copy(input, temp, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Tamano de image: " + temp.toFile().length());

                byte[] byteP;
                byteP = Files.readAllBytes(temp);
                File temp2 = File.createTempFile("image", "jpeg", ima);
                FileOutputStream fos = new FileOutputStream(temp2);
                fos.write(byteP);

                Imagenes imagen = new Imagenes();
                imagen.setImagen(byteP);
                imagen.setPath(temp2.getName());
                user.setFoto_perfil(imagen);

                ManejadorImagen.getInstance().insertIntoDatabase(imagen);
                ManejadorUsuario.getInstance().updateObject(user);

            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }


            response.redirect("/index");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();
            System.out.println("llego");
            //   resultTemplate.process(attributes, writer);
            return writer;

        });

        Spark.get("/logout", (request, response) -> {

            Session session = request.session(true);
            session.invalidate();

            response.redirect("/Login");
            return "";
        });
        Spark.get("/members", (request, response) -> {
            Template resultTemplate = configuration.getTemplate("templates/amigos.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();
            Usuario user = request.session().attribute("username");
            List<Amigos> amigos = ManejadorAmigos.getInstance().getAllObjects();
            List<Usuario> listuser = new ArrayList<>();
            for (Usuario item : ManejadorUsuario.getInstance().getUserBuUP(user.getLugar_nacimiento(), user.getCiudad())
                    ) {
                if (!item.getEmail().equalsIgnoreCase(user.getEmail())) {
                    if (ManejadorAmigos.getInstance().getAllObjects().size() == 0) {
                        System.out.println("AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
                        listuser.add(item);
                    } else {
                        for (int i = 0; i < amigos.size(); i++) {
                            if (!amigos.get(i).getUsuario().getEmail().equalsIgnoreCase(item.getEmail())) {
                                listuser.add(item);
                            }
                        }

                    }
                }
            }
            attributes.put("listuser", listuser);
            attributes.put("usera", user);
            resultTemplate.process(attributes, writer);
            return writer;
        });

        Spark.get("/solicitud/:id", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));

            System.out.println(id);
            Usuario user = request.session().attribute("username");
            Usuario user2 = ManejadorUsuario.getInstance().findObjectWithId(id);
            if (user2 != user)
                user2.getSolicitudes().add(user);
            ManejadorUsuario.getInstance().updateObject(user2);
            System.out.println(user2.getNombre());
            return "";
        });

        Spark.get("/solicitud_acept/:id", (request, response) -> {
            System.out.println("Llego aqui: ");
            int id = Integer.parseInt(request.params("id"));

            Usuario user = request.session().attribute("username");
            Usuario user2 = ManejadorUsuario.getInstance().findObjectWithId(id);

            Amigos amigo_new = new Amigos();
            amigo_new.setUsuario(user2);
            ManejadorAmigos.getInstance().insertIntoDatabase(amigo_new);
            user.getAmigos().add(amigo_new);
            ManejadorUsuario.getInstance().updateObject(user);

            Amigos amigos_new_2 = new Amigos();
            amigos_new_2.setUsuario(user);
            ManejadorAmigos.getInstance().insertIntoDatabase(amigos_new_2);
            user2.getAmigos().add(amigos_new_2);
            ManejadorUsuario.getInstance().updateObject(user2);

            return "";
        });

        Spark.get("/acept", (request, response) -> {

            Template resultTemplate = configuration.getTemplate("templates/solicitudes.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> attributes = new HashMap<>();
            Usuario user = request.session().attribute("username");
            List<Usuario> listuser = new ArrayList<>();
            List<Amigos> amigos_add = ManejadorAmigos.getInstance().getAllObjects();
            for (Usuario item : user.getSolicitudes()
                    ) {

                if (amigos_add.size() == 0) {
                    listuser.add(item);
                } else {
                    for (Amigos amigo : amigos_add) {
                        System.out.println("llegue aqui mg1");
                        if (amigo.getUsuario().getEmail().equalsIgnoreCase(item.getEmail())) {
                            System.out.println("ya esta agregado");
                        } else if (item.getEmail().equalsIgnoreCase(user.getEmail())) {
                            System.out.println("es usted mismo");
                        } else {
                            System.out.println("AQUIIIIIIIIIIIIIIIIIIIIII");
                            listuser.add(item);
                        }
                    }
                }

            }
            System.out.println("Tiene un size de: " + listuser.size());
            attributes.put("listuser", listuser);
            attributes.put("usera", user);
            resultTemplate.process(attributes, writer);
            return writer;
        });

    before("/profile",(request, response) ->

    {
        autorizado(request, response);
    });

    before("/index",(request, response) ->

    {
        autorizado(request, response);
    });

    before("/adminUsuarios",(request, response) ->

    {
        Usuario user = request.session().attribute("usuario");
        if (user == null) {
            response.redirect("/login");
        } else {
            if (!user.isEsAdmin()) {
                response.redirect("/profile");
            }
        }
    });

}

    private static void autorizado(Request request, Response response) {

        Session ses = request.session(true);
        Usuario user = ses.attribute("username");

        if (user == null) {
            halt(401, "No Autorizado");
        }
    }
    private static String convertStreamToString(InputStream input) {
        Scanner scanner = new Scanner(input).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }


    public static byte[] readFully(InputStream input, int size) throws IOException {
        byte[] buffer = new byte[size];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        return output.toByteArray();
    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

}