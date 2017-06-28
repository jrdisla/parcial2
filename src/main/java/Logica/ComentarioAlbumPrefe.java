package Logica;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jrdis on 16/6/2017.
 */
@Entity
@Table(name = "Comentario_Album_Prefes")
@NamedQueries({
        @NamedQuery(
                name = "commentAlbumPrefe.getPrefe",
                query = "SELECT commentLikeDis FROM Logica.ComentarioAlbumPrefe commentLikeDis WHERE commentLikeDis.usuario.id = :userId " +
                        "AND commentLikeDis.comentarioalbum.id = :commentId"
        )
})
public class ComentarioAlbumPrefe implements Serializable {
    public static String getLikeDisByUserComment= "commentAlbumPrefe.getPrefe";


    @Id
    @GeneratedValue
    @Expose
    private int id;
    @ManyToOne
    @JoinColumn(name = "usuario",nullable = false)
    @Expose
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "comentarioalbum",nullable = false)
    private ComentarioAlbum comentarioalbum;

    @Column(name = "preferencia",nullable = false)
    private String preferencia;

    public ComentarioAlbumPrefe() {
    }

    public ComentarioAlbumPrefe(Usuario usuario, ComentarioAlbum comentarioalbum, String preferencia) {
        this.usuario = usuario;
        this.comentarioalbum = comentarioalbum;
        this.preferencia = preferencia;
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

    public ComentarioAlbum getComentarioalbum() {
        return comentarioalbum;
    }

    public void setComentarioalbum(ComentarioAlbum comentarioalbum) {
        this.comentarioalbum = comentarioalbum;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }
}
