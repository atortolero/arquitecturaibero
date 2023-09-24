package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;

@Entity
@Table(name="sesion")
public class Sesion
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sesion_seq")
    @SequenceGenerator(name = "sesion_seq", sequenceName = "sesion_seq", initialValue = 1, allocationSize=1)
    @Column(name="sesionid")
    private long sesionid;

    @Column(name="token")
    private String token;

    @Column(name="ip")
    private String ip;

    @Column(name="fechainicio")
    private String fechainicio;

    @Column(name="fechaactividad")
    private String fechaactividad;

    @OneToOne
    @JoinColumn(name = "usuarioid", referencedColumnName = "usuarioid")
    private Usuarios usuario;

    public Sesion() {
    }

    public Sesion(long sesionid, String token, String ip, String fechainicio, String fechaactividad, Usuarios usuario) {
        this.sesionid = sesionid;
        this.token = token;
        this.ip = ip;
        this.fechainicio = fechainicio;
        this.fechaactividad = fechaactividad;
        this.usuario = usuario;
    }

    public long getSesionid() {
        return sesionid;
    }

    public void setSesionid(long sesionid) {
        this.sesionid = sesionid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechaactividad() {
        return fechaactividad;
    }

    public void setFechaactividad(String fechaactividad) {
        this.fechaactividad = fechaactividad;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
