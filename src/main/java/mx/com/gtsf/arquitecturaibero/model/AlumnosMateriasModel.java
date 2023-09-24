package mx.com.gtsf.arquitecturaibero.model;

import java.util.List;

public class AlumnosMateriasModel {

    private long areaid;
    private String area;
    private long materiaid;
    private String materia;
    private String clave;
    private String color;
    private int creditos;
    private String descripcion;
    private int horas;
    private boolean obligatoria;
    private long opcionid;
    private String opcion;
    private String sigla;
    private long secuenciaFormativaid;
    private String secuenciaFormativa;
    private int semestreIdeal;
    private String siglas;
    private int status; //0 = sin agendar, 1 = agendada pero no cursada, 2 = cursando, 3 = aprobada, 4 = reprobada, 5 = baja, 6 = por definir
    List<AlumnosPrerrequisitosModel>  prerrequisitos;

    public AlumnosMateriasModel() {
    }

    public AlumnosMateriasModel(long areaid, String area, long materiaid, String materia, String clave, String color, int creditos, String descripcion, int horas, boolean obligatoria, long opcionid, String opcion, String sigla, long secuenciaFormativaid, String secuenciaFormativa, int semestreIdeal, String siglas, int status, List<AlumnosPrerrequisitosModel> prerrequisitos) {
        this.areaid = areaid;
        this.area = area;
        this.materiaid = materiaid;
        this.materia = materia;
        this.clave = clave;
        this.color = color;
        this.creditos = creditos;
        this.descripcion = descripcion;
        this.horas = horas;
        this.obligatoria = obligatoria;
        this.opcionid = opcionid;
        this.opcion = opcion;
        this.sigla = sigla;
        this.secuenciaFormativaid = secuenciaFormativaid;
        this.secuenciaFormativa = secuenciaFormativa;
        this.semestreIdeal = semestreIdeal;
        this.siglas = siglas;
        this.status = status;
        this.prerrequisitos = prerrequisitos;
    }

    public long getAreaid() {
        return areaid;
    }

    public void setAreaid(long areaid) {
        this.areaid = areaid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public boolean isObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public long getSecuenciaFormativaid() {
        return secuenciaFormativaid;
    }

    public void setSecuenciaFormativaid(long secuenciaFormativaid) {
        this.secuenciaFormativaid = secuenciaFormativaid;
    }

    public String getSecuenciaFormativa() {
        return secuenciaFormativa;
    }

    public void setSecuenciaFormativa(String secuenciaFormativa) {
        this.secuenciaFormativa = secuenciaFormativa;
    }

    public int getSemestreIdeal() {
        return semestreIdeal;
    }

    public void setSemestreIdeal(int semestreIdeal) {
        this.semestreIdeal = semestreIdeal;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<AlumnosPrerrequisitosModel> getPrerrequisitos() {
        return prerrequisitos;
    }

    public void setPrerrequisitos(List<AlumnosPrerrequisitosModel> prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }

    @Override
    public String toString() {
        return "AlumnosMateriasModel{" +
                "areaid=" + areaid +
                ", area='" + area + '\'' +
                ", materiaid=" + materiaid +
                ", materia='" + materia + '\'' +
                ", clave='" + clave + '\'' +
                ", color='" + color + '\'' +
                ", creditos=" + creditos +
                ", descripcion='" + descripcion + '\'' +
                ", horas=" + horas +
                ", obligatoria=" + obligatoria +
                ", opcionid=" + opcionid +
                ", opcion='" + opcion + '\'' +
                ", sigla='" + sigla + '\'' +
                ", secuenciaFormativaid=" + secuenciaFormativaid +
                ", secuenciaFormativa='" + secuenciaFormativa + '\'' +
                ", semestreIdeal=" + semestreIdeal +
                ", siglas='" + siglas + '\'' +
                ", status=" + status +
                ", prerrequisitos=" + prerrequisitos +
                '}';
    }
}
