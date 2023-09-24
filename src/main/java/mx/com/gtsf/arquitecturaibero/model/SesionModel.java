package mx.com.gtsf.arquitecturaibero.model;

import mx.com.gtsf.arquitecturaibero.entity.Usuarios;

public class SesionModel {

    private long sesionid;
    private String token;
    private String ip;
    private String fechainicio;
    private String fechaactividad;
    private Usuarios usuario;

    public SesionModel(long sesionid, String token, String ip, String fechainicio, String fechaactividad, Usuarios usuario) {
        this.sesionid = sesionid;
        this.token = token;
        this.ip = ip;
        this.fechainicio = fechainicio;
        this.fechaactividad = fechaactividad;
        this.usuario = usuario;
    }

    public SesionModel() {
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

    @Override
    public String toString() {
        return "SesionModel{" +
                "sesionid=" + sesionid +
                ", token='" + token + '\'' +
                ", ip='" + ip + '\'' +
                ", fechainicio='" + fechainicio + '\'' +
                ", fechaactividad='" + fechaactividad + '\'' +
                ", usuarios=" + usuario +
                '}';
    }
}
