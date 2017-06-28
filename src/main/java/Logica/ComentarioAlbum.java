package Logica;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jrdis on 16/6/2017.
 */
@Entity
@Table(name = "Comentarios_Album")
@NamedQueries({
        @NamedQuery(
                name = "Comment.deleteCommentById",
                query = "DELETE FROM Logica.ComentarioAlbum comment WHERE comment.id = :id"
        )
})
public class ComentarioAlbum implements Serializable {

    public static String deleteCommentById = "Comment.deleteCommentById";

    @Id
    @GeneratedValue
    @Expose
    private int id;
    @ManyToOne
    @JoinColumn(name = "usuario",nullable = false)
    @Expose
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "album",nullable = false)
    @Expose
    private Album album;
    @Column(name = "cuerpo",nullable = false)
    @Expose
    private String cuerpo;
    @OneToMany(mappedBy = "comentarioalbum",cascade = CascadeType.REMOVE)
    private Set<ComentarioAlbumPrefe> comentarioAlbumPrefes = new HashSet<>();

    public ComentarioAlbum() {
    }

    public ComentarioAlbum(Usuario usuario, Album album, String cuerpo, Set<ComentarioAlbumPrefe> comentarioAlbumPrefes) {
        this.usuario = usuario;
        this.album = album;
        this.cuerpo = cuerpo;
        this.comentarioAlbumPrefes = comentarioAlbumPrefes;
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Set<ComentarioAlbumPrefe> getComentarioAlbumPrefes() {
        return comentarioAlbumPrefes;
    }

    public void setComentarioAlbumPrefes(Set<ComentarioAlbumPrefe> comentarioAlbumPrefes) {
        this.comentarioAlbumPrefes = comentarioAlbumPrefes;
    }
}
