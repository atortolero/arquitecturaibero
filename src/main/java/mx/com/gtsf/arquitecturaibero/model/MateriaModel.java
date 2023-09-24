package mx.com.gtsf.arquitecturaibero.model;

import java.util.List;

public class MateriaModel {

    private long materiaid;
    private String materia;
    private String clave;
    private String sigla;
    private int creditos;
    private int horas;
    private int semestreIdeal;
    private boolean obligatoria;
    private boolean verano;
    private long areaid;
    private String area;
    private long secuenciaFormativaid;
    private String secuenciaFormativa;
    private long planid;
    private long opcionid;
    private String opcion;
    private String descripcion;
    private List<PrerrequisitosModel> prerrequisitos;

    public MateriaModel() {
    }

    public MateriaModel(long materiaid, String materia, String clave, String sigla, int creditos, int horas, int semestreIdeal, boolean obligatoria, boolean verano, long areaid, String area, long secuenciaFormativaid, String secuenciaFormativa, long planid, long opcionid, String opcion, String descripcion, List<PrerrequisitosModel> prerrequisitos) {
        this.materiaid = materiaid;
        this.materia = materia;
        this.clave = clave;
        this.sigla = sigla;
        this.creditos = creditos;
        this.horas = horas;
        this.semestreIdeal = semestreIdeal;
        this.obligatoria = obligatoria;
        this.verano = verano;
        this.areaid = areaid;
        this.area = area;
        this.secuenciaFormativaid = secuenciaFormativaid;
        this.secuenciaFormativa = secuenciaFormativa;
        this.planid = planid;
        this.opcionid = opcionid;
        this.opcion = opcion;
        this.descripcion = descripcion;
        this.prerrequisitos = prerrequisitos;
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

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getSemestreIdeal() {
        return semestreIdeal;
    }

    public void setSemestreIdeal(int semestreIdeal) {
        this.semestreIdeal = semestreIdeal;
    }

    public boolean isObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
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

    public long getSecuenciaFormativaid() {
        return secuenciaFormativaid;
    }

    public void setSecuenciaFormativaid(long secuenciaFormativaid) {
        this.secuenciaFormativaid = secuenciaFormativaid;
    }

    public long getOpcionid() {
        return opcionid;
    }

    public void setOpcionid(long opcionid) {
        this.opcionid = opcionid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<PrerrequisitosModel> getPrerrequisitos() {
        return prerrequisitos;
    }

    public void setPrerrequisitos(List<PrerrequisitosModel> prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }

    public long getPlanid() {
        return planid;
    }

    public void setPlanid(long planid) {
        this.planid = planid;
    }

    public String getSecuenciaFormativa() {
        return secuenciaFormativa;
    }

    public void setSecuenciaFormativa(String secuenciaFormativa) {
        this.secuenciaFormativa = secuenciaFormativa;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public boolean isVerano() {
        return verano;
    }

    public void setVerano(boolean verano) {
        this.verano = verano;
    }

    @Override
    public String toString() {
        return "MateriaModel{" +
                "materiaid=" + materiaid +
                ", materia='" + materia + '\'' +
                ", clave='" + clave + '\'' +
                ", sigla='" + sigla + '\'' +
                ", creditos=" + creditos +
                ", horas=" + horas +
                ", semestreIdeal=" + semestreIdeal +
                ", obligatoria=" + obligatoria +
                ", verano=" + verano +
                ", areaid=" + areaid +
                ", area='" + area + '\'' +
                ", secuenciaFormativaid=" + secuenciaFormativaid +
                ", secuenciaFormativa='" + secuenciaFormativa + '\'' +
                ", planid=" + planid +
                ", opcionid=" + opcionid +
                ", opcion='" + opcion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prerrequisitos=" + prerrequisitos +
                '}';
    }
}
