package mx.com.gtsf.arquitecturaibero.model;

public class MateriasModel {

    private long materiaid;
    private String materia;
    private String clave;
    private String sigla;

    public MateriasModel() {
    }

    public MateriasModel(long materiaid, String materia, String clave, String sigla) {
        this.materiaid = materiaid;
        this.materia = materia;
        this.clave = clave;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "MateriasModel{" +
                "materiaid=" + materiaid +
                ", materia='" + materia + '\'' +
                ", clave='" + clave + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
