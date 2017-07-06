package Logica;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cesarjose on 6/26/17.
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
        @NamedQuery(
                name = "User.findUserByUsername",
                query = "SELECT user FROM Logica.Usuario user WHERE user.email = :email"
        ),
        @NamedQuery(
                name = "User.findUserByUsernameAndPassword",
                query = "SELECT user FROM Logica.Usuario user WHERE user.lugar_nacimiento = :lugar_naci AND user.ciudad = :ciudad"
        )
})
public class Usuario implements Serializable {
    public static String getUser = "User.findUserByUsername";
    public static String chekUserPassword = "User.findUserByUsernameAndPassword";

    @Id
    @GeneratedValue
    @Expose
    private int id;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "apellido",nullable = false)
    private String apellido;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "fecha_naci")
    private Date fecha_nacimiento;
    @Column(name = "lugar_naci")
    private String lugar_nacimiento;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "lugares_estudio")
    private String lugares_estudio;
    @Column(name = "lugares_trabajo")
    private String lugares_trabajo;
    @Column(name = "cuenta_ig")
    private String ig_cuenta;
    @Column(name = "foto",length = 500000000)
    private Imagenes foto_perfil;
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private Set<Album> albums = new HashSet<>();
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private Set<Articulo> articulos = new HashSet<>();
    @OneToMany
    private Set<Usuario> amigos = new HashSet<>();
    @OneToMany
    private Set<Usuario> solicitudes = new HashSet<>();
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_registro")
    private Date fecha_registro;
    @Column(name = "idiomas")
    private String idiomas;
    @Column(name = "esAdmin")
    private boolean esAdmin;
    @Column(name = "contraseña")
    private String contraseña;

    public Usuario() {

    }

    public Usuario(String email, String nombre, String apellido ,Date fecha_nacimiento, String lugar_nacimiento, String ciudad, Date fecha_registro, String idiomas, String contraseña) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.ciudad = ciudad;
        this.fecha_registro = fecha_registro;
        this.idiomas = idiomas;
        this.contraseña = contraseña;
    }

    public Usuario(String email, String nombre, String apellido, String sexo ,Date fecha_nacimiento, String lugar_nacimiento, String ciudad, Date fecha_registro, String idiomas, String contraseña) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.ciudad = ciudad;
        this.fecha_registro = fecha_registro;
        this.idiomas = idiomas;
        this.contraseña = contraseña;
    }

    public Set<Usuario> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Set<Usuario> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Usuario(String email, String nombre, String apellido, Date fecha_nacimiento, String lugar_nacimiento, String ciudad, String lugares_estudio, String lugares_trabajo, String ig_cuenta, Imagenes foto_perfil, Set<Album> albums, Set<Articulo> articulos, Set<Usuario> amigos, String descripcion, Date fecha_registro, String idiomas, boolean esAdmin, String contraseña) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.ciudad = ciudad;
        this.lugares_estudio = lugares_estudio;
        this.lugares_trabajo = lugares_trabajo;
        this.ig_cuenta = ig_cuenta;
        this.foto_perfil = foto_perfil;
        this.albums = albums;
        this.articulos = articulos;
        this.amigos = amigos;
        this.descripcion = descripcion;
        this.fecha_registro = fecha_registro;
        this.idiomas = idiomas;
        this.esAdmin = esAdmin;
        this.contraseña = contraseña;
    }

    public Usuario(String email, String nombre, String apellido, boolean esAdmin, String contraseña) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.esAdmin = esAdmin;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLugares_estudio() {
        return lugares_estudio;
    }

    public void setLugares_estudio(String lugares_estudio) {
        this.lugares_estudio = lugares_estudio;
    }

    public String getLugares_trabajo() {
        return lugares_trabajo;
    }

    public void setLugares_trabajo(String lugares_trabajo) {
        this.lugares_trabajo = lugares_trabajo;
    }

    public String getIg_cuenta() {
        return ig_cuenta;
    }

    public void setIg_cuenta(String ig_cuenta) {
        this.ig_cuenta = ig_cuenta;
    }

    public Imagenes getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(Imagenes foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(Set<Articulo> articulos) {
        this.articulos = articulos;
    }

    public Set<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(Set<Usuario> amigos) {
        this.amigos = amigos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
