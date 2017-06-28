package Logica;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jrdis on 16/6/2017.
 */
@Entity
@Table(name = "Comentario_Preferencia_Articulos")
@NamedQueries({
        @NamedQuery(
                name = "commentLikeDis.getLikeDisle",
                query = "SELECT commentLikeDis FROM Logica.ComentarioPreferenciaArti commentLikeDis WHERE commentLikeDis.usuario.id = :usuarioId " +
                        "AND commentLikeDis.comentarioArticulo.id = :comentarioalbumId"
        )
})
public class ComentarioPreferenciaArti implements Serializable {

    public static String getLikeDisByUserComment= "commentLikeDis.getLikeDisle";

    @Id
    @GeneratedValue
    @Expose
    private int id;
    @Column(name = "preferencia")
    private String Preferencia;
    @ManyToOne
    @JoinColumn(name = "usuario",nullable = false)
    private Usuario usuario;
    @ManyToOne
    private ComentarioArticulo comentarioArticulo;

    public ComentarioPreferenciaArti() {
    }

    public ComentarioPreferenciaArti(String preferencia, Usuario user, ComentarioArticulo comentarioArticulo) {
        Preferencia = preferencia;
        this.usuario = user;
        this.comentarioArticulo = comentarioArticulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreferencia() {
        return Preferencia;
    }

    public void setPreferencia(String preferencia) {
        Preferencia = preferencia;
    }

    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario user) {
        this.usuario = user;
    }

    public ComentarioArticulo getComentarioArticulo() {
        return comentarioArticulo;
    }

    public void setComentarioArticulo(ComentarioArticulo comentarioArticulo) {
        this.comentarioArticulo = comentarioArticulo;
    }
}
