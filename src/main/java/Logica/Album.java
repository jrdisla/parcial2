package Logica;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jrdis on 16/6/2017.
 */
@Entity
@Table(name = "Album")
@NamedQueries({
        @NamedQuery(
                name = "Album.ByUsername",
                query = "Select arti FROM Logica.Album arti WHERE arti.usuario.email = :email"

        ),
        @NamedQuery(
                name = "Album.findArticlesPag",
                query = "SELECT arti FROM Logica.Album arti ORDER BY arti.fecha DESC"
        )

})
public class Album implements Serializable {
    public static String by_title = "Album.ByUsername";
    public static String pag = "Album.findArticlesPag";

    @Id
    @GeneratedValue
    @Expose
    private int id;
    @Expose
    @ManyToOne
    @JoinColumn(name = "usuario",nullable = false)
    private Usuario usuario;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "album")
    private Set<ComentarioAlbum> comentarioAlbums = new HashSet<>();
    @OneToMany
    private Set<Imagenes> imagenes = new HashSet<>();
    @Column(name = "fecha")
    private Date fecha;

    public Album() {
    }

    public Album(Usuario usuario, String titulo, String descripcion, Set<Imagenes> imagenes) {
        this.usuario = usuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<ComentarioAlbum> getComentarioAlbums() {
        return comentarioAlbums;
    }

    public void setComentarioAlbums(Set<ComentarioAlbum> comentarioAlbums) {
        this.comentarioAlbums = comentarioAlbums;
    }

    public Set<Imagenes> getImagenes() {
        return imagenes;
    }

    public void setImagenes(Set<Imagenes> imagenes) {
        this.imagenes = imagenes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
