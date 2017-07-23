package Logica;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jrdis on 16/6/2017.
 */
@Entity
@Table(name = "Articulos")
@NamedQueries({
        @NamedQuery(
                name = "Article.ByUsername",
                query = "Select arti FROM Logica.Articulo arti WHERE arti.usuario.email = :email"

        ),
        @NamedQuery(
                name = "Article.findArticlesPag",
                query = "SELECT arti FROM Logica.Articulo arti ORDER BY arti.fecha DESC"
        )


})
public class Articulo implements Serializable {

    public static String by_title = "Article.ByUsername";
    public static String pag = "Article.findArticlesPag";


    @Id
    @GeneratedValue
    @Expose
    private int id;
    @Expose
    @ManyToOne
    @JoinColumn(name = "usuario",nullable = false)
    private Usuario usuario;
    @OneToMany(mappedBy = "articulo",cascade = CascadeType.REMOVE)
    private Set<ComentarioArticulo> ComentarioArticulo = new HashSet<>();
    @OneToMany(mappedBy = "articulo",cascade = CascadeType.REMOVE)
    private Set<ArticuloPreferencia> preferencia = new HashSet<>();;
    @Column(name = "fecha")
    private Date fecha;
    @Expose
    @ManyToMany
    @JoinTable(name = "usuario")
    private Set<Usuario> etiquetas = new HashSet<>();
    @Expose
    @ManyToMany
    @JoinTable(name = "usuario")
    private Set<Usuario>  usuarios_permitidos = new HashSet<>();
    @Column(name = "body")
    private String body;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "imagen",length = 500000000)
    private Imagenes imagen;
    @Column(name = "count_")
    private int count_;
    @Column(name = "dislike")
    private int dislike;

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getCount_() {
        return count_;
    }

    public void setCount_(int count_) {
        this.count_ = count_;
    }

    public Articulo() {
    }

    public Articulo(Usuario user, Date fecha, Set<Usuario> usuarios_ven, String body, String titulo) {
        this.usuario = user;
        this.fecha = fecha;
        this.usuarios_permitidos = usuarios_ven;
        this.body = body;
        this.titulo = titulo;
    }

    public static String getBy_title() {
        return by_title;
    }

    public static void setBy_title(String by_title) {
        Articulo.by_title = by_title;
    }

    public static String getPag() {
        return pag;
    }

    public static void setPag(String pag) {
        Articulo.pag = pag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Logica.ComentarioArticulo> getComentarioArticulo() {
        return ComentarioArticulo;
    }

    public void setComentarioArticulo(Set<Logica.ComentarioArticulo> comentarioArticulo) {
        ComentarioArticulo = comentarioArticulo;
    }

    public Set<ArticuloPreferencia> getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Set<ArticuloPreferencia> preferencia) {
        this.preferencia = preferencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Set<Usuario> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Set<Usuario> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Set<Usuario> getUsuarios_ven() {
        return usuarios_permitidos;
    }

    public void setUsuarios_ven(Set<Usuario> usuarios_ven) {
        this.usuarios_permitidos = usuarios_ven;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Imagenes getImagen() {
        return imagen;
    }

    public void setImagen(Imagenes imagen) {
        this.imagen = imagen;
    }


}
