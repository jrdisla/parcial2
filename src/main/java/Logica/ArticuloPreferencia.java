package Logica;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jrdis on 16/6/2017.
 */
@Entity
@Table(name = "Articulos_Preferencias")
@NamedQueries({
        @NamedQuery(
                name = "ArtiPrefe.getByArtiUser",
                query = "SELECT artiLikeDis FROM Logica.ArticuloPreferencia artiLikeDis WHERE artiLikeDis.usuario.id = :userId " +
                        "AND artiLikeDis.articulo.id = :articleId"
        )
})
public class ArticuloPreferencia implements Serializable {
    public static String getLikeDis = "ArtiPrefe.getByArtiUser";

    @Id
    @GeneratedValue
    @Expose
    private int id;
    @ManyToOne
    @JoinColumn(name = "usuario",nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "articulo",nullable = false)
    @Expose
    private Articulo articulo;
    @Column(name = "preferencia")
    @Expose
    private String preferencia;

    public ArticuloPreferencia() {
    }

    public ArticuloPreferencia( Usuario usuario, Articulo articulo, String preferencia) {
        this.usuario = usuario;
        this.articulo = articulo;
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

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }
}
