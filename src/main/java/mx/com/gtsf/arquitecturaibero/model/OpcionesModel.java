package mx.com.gtsf.arquitecturaibero.model;

public class OpcionesModel {

    private long opcionid;
    private String opcion;

    public OpcionesModel() {
    }

    public OpcionesModel(long opcionid, String opcion) {
        this.opcionid = opcionid;
        this.opcion = opcion;
    }

    public long getOpcionid() {
        return opcionid;
    }

    public void setOpcionid(long opcionid) {
        this.opcionid = opcionid;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    @Override
    public String toString() {
        return "OpcionesModel{" +
                "opcionid=" + opcionid +
                ", opcion='" + opcion + '\'' +
                '}';
    }
}
