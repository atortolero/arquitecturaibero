package mx.com.gtsf.arquitecturaibero.model;

public class TipoUsuarioModel {

    private long tipoid;
    private String descripcion;

    public TipoUsuarioModel(long tipoid, String descripcion) {
        this.tipoid = tipoid;
        this.descripcion = descripcion;
    }

    public TipoUsuarioModel() {
    }

    public long getTipoid() {
        return tipoid;
    }

    public void setTipoid(long tipoid) {
        this.tipoid = tipoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoUsuarioModel{" +
                "tipoid=" + tipoid +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
