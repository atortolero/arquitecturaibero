package mx.com.gtsf.arquitecturaibero.model;

public class PrerrequisitosModel {

    private long materiaid;
    private String materia;
    private String clave;

    public PrerrequisitosModel() {
    }

    public PrerrequisitosModel(long materiaid, String materia, String clave) {
        this.materiaid = materiaid;
        this.materia = materia;
        this.clave = clave;
    }

    public long getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(long materiaid) {
        this.materiaid = materiaid;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "PrerrequisitosModel{" +
                "materiaid=" + materiaid +
                ", materia='" + materia + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }
}
