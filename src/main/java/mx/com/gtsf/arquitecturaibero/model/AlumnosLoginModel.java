package mx.com.gtsf.arquitecturaibero.model;

public class AlumnosLoginModel {

    private int estatus;
    private String mensaje;
    private AlumnosLoginModelDatos datos;

    public AlumnosLoginModel() {
    }

    public AlumnosLoginModel(int estatus, String mensaje, AlumnosLoginModelDatos datos) {
        this.estatus = estatus;
        this.mensaje = mensaje;
        this.datos = datos;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public AlumnosLoginModelDatos getDatos() {
        return datos;
    }

    public void setDatos(AlumnosLoginModelDatos datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        return "AlumnosLoginModelDatos{" +
                "estatus=" + estatus +
                ", mensaje='" + mensaje + '\'' +
                ", datos=" + datos +
                '}';
    }
}
