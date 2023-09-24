package mx.com.gtsf.arquitecturaibero.model;

public class AlumnosPrerrequisitosModel {

    private long materiaid;
    private String materia;
    private String clave;
    private String periodo;
    private int status; //0 = sin agendar, 1 = agendada pero no cursada, 2 = cursando, 3 = aprobada, 4 = reprobada, 5 = baja, 6 = por definir

    public AlumnosPrerrequisitosModel() {
    }

    public AlumnosPrerrequisitosModel(long materiaid, String materia, String clave, String periodo, int status) {
        this.materiaid = materiaid;
        this.materia = materia;
        this.clave = clave;
        this.periodo = periodo;
        this.status = status;
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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AlumnosPrerrequisitosModel{" +
                "materiaid=" + materiaid +
                ", materia='" + materia + '\'' +
                ", clave='" + clave + '\'' +
                ", periodo='" + periodo + '\'' +
                ", status=" + status +
                '}';
    }
}
