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
@Table(name = "comentarioArticulos")
@NamedQueries({
        @NamedQuery(
                name = "CommentArti.deleteCommentById",
                query = "DELETE FROM Logica.ComentarioArticulo comment WHERE comment.id = :id"
        )
})
public class ComentarioArticulo implements Serializable {

    public static String deleteCommentById = "CommentArti.deleteCommentById";

    @Id
    @GeneratedValue
    @Expose
    private int id;
    @ManyToOne
    @JoinColumn(name = "articulo",nullable = false)
    @Expose
    private Articulo articulo;
    @ManyToOne
    @JoinColumn(name = "usuario",nullable = false)
    @Expose
    private Usuario usuario;
    @Column(name = "body")
    private String body;
    @OneToMany
    private Set<ComentarioPreferenciaArti> comentarioPreferenciaArtis;

    public ComentarioArticulo() {
    }

    public ComentarioArticulo(Articulo articulo, Usuario user, String body, Set<ComentarioPreferenciaArti> comentarioPreferenciaSet) {
        this.articulo = articulo;
        this.usuario = user;
        this.body = body;
        this.comentarioPreferenciaArtis = comentarioPreferenciaSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario user) {
        this.usuario = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<ComentarioPreferenciaArti> getComentarioPreferenciaSet() {
        return comentarioPreferenciaArtis;
    }

    public void setComentarioPreferenciaSet(Set<ComentarioPreferenciaArti> comentarioPreferenciaSet) {
        this.comentarioPreferenciaArtis = comentarioPreferenciaSet;
    }
}
