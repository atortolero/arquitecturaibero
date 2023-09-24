package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="usuarios_seq")
    @SequenceGenerator(name = "usuarios_seq", sequenceName = "usuarios_seq", initialValue = 1, allocationSize=1)
    @Column(name="usuarioid")
    private long usuarioid;

    @Column(name="admininterno")
    private long admininterno;

    @Column(name="password")
    private String password;

    @Column(name="nombre")
    private String nombre;

    @Column(name="appaterno")
    private String appaterno;

    @Column(name="apmaterno")
    private String apmaterno;

    @Column(name="email")
    private String email;

    @Column(name="activo")
    private int activo;

    @Column(name="alumnoid")
    private long alumnoid;

    @OneToOne(mappedBy = "usuario")
    private Sesion sesion;

    @ManyToOne
    @JoinColumn(name = "tipoid")
    private TipoUsuario tipoUsuario;

    public Usuarios() {
    }

    public Usuarios(long usuarioid, long admininterno, String password, String nombre, String appaterno, String apmaterno, String email, int activo, long alumnoid, Sesion sesion, TipoUsuario tipoUsuario) {
        this.usuarioid = usuarioid;
        this.admininterno = admininterno;
        this.password = password;
        this.nombre = nombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.email = email;
        this.activo = activo;
        this.alumnoid = alumnoid;
        this.sesion = sesion;
        this.tipoUsuario = tipoUsuario;
    }

    public long getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(long usuarioid) {
        this.usuarioid = usuarioid;
    }

    public long getAdmininterno() {
        return admininterno;
    }

    public void setAdmininterno(long admininterno) {
        this.admininterno = admininterno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public long getAlumnoid() {
        return alumnoid;
    }

    public void setAlumnoid(long alumnoid) {
        this.alumnoid = alumnoid;
    }
}
