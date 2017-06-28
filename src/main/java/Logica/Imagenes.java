package Logica;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jrdis on 16/6/2017.
 */
@Entity
@Table(name = "imagenes")
public class Imagenes implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "imagen")
    private byte [] imagen;
    @ManyToOne
    @JoinColumn(name = "album",nullable = false)
    @Expose
    private Album album;

    public Imagenes() {
    }

    public Imagenes(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
