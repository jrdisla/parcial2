package Cliente_REST;

/**
 * Created by jrdis on 16/6/2017.
 */
public class Articulo_Body {
    private String titulo;
    private String body;

    public Articulo_Body() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
