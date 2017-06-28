package Logica;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jrdis on 16/6/2017.
 */
@Entity
@Table(name = "Album_Preferencias")
@NamedQueries({
        @NamedQuery(
                name = "AlbumPrefe.getByArtiUser",
                query = "SELECT artiLikeDis FROM Logica.AlbumPreferencia artiLikeDis WHERE artiLikeDis.usuario.id = :usuarioId " +
                        "AND artiLikeDis.album.id = :albumId"
        )
})
public class AlbumPreferencia implements Serializable {

    public static String getLikeDis = "AlbumPrefe.getByArtiUser";

    @Id
    @GeneratedValue
    @Expose
    private int id;
    @ManyToOne
    @JoinColumn(name = "usuario",nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "album",nullable = false)
    @Expose
    private Album album;
    @Column(name = "preferencia")
    private String preferencia;

    public AlbumPreferencia() {
    }

    public AlbumPreferencia(Usuario usuario, Album album, String preferencia) {
        this.usuario = usuario;
        this.album = album;
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }
}
