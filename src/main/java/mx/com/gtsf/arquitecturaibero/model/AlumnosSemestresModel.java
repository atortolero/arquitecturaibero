package mx.com.gtsf.arquitecturaibero.model;

import java.util.List;

public class AlumnosSemestresModel {

    private int anioPeriodo;
    private String fin;
    private List<AlumnosMateriasModel> materias;
    private String periodo;
    private String semestre;
    private long semestreid;
    private int status; // 0 = futuro, 1 = actual, 2 = pasado.
    private long tipoPeriodoID; // 1 = primavera, 2 = verano, 3 = otoño
    private long planID;
    private long userID;

    public AlumnosSemestresModel() {
    }

    public AlumnosSemestresModel(int anioPeriodo, String fin, String periodo, long semestreid, String semestre, int status, long tipoPeriodoID, long planID, long userID, List<AlumnosMateriasModel> materias) {
        this.anioPeriodo = anioPeriodo;
        this.fin = fin;
        this.periodo = periodo;
        this.semestreid = semestreid;
        this.semestre = semestre;
        this.status = status;
        this.tipoPeriodoID = tipoPeriodoID;
        this.planID = planID;
        this.userID = userID;
        this.materias = materias;
    }

    public int getAnioPeriodo() {
        return anioPeriodo;
    }

    public void setAnioPeriodo(int anioPeriodo) {
        this.anioPeriodo = anioPeriodo;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public long getSemestreid() {
        return semestreid;
    }

    public void setSemestreid(long semestreid) {
        this.semestreid = semestreid;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTipoPeriodoID() {
        return tipoPeriodoID;
    }

    public void setTipoPeriodoID(long tipoPeriodoID) {
        this.tipoPeriodoID = tipoPeriodoID;
    }

    public long getPlanID() {
        return planID;
    }

    public void setPlanID(long planID) {
        this.planID = planID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public List<AlumnosMateriasModel> getMaterias() {
        return materias;
    }

    public void setMaterias(List<AlumnosMateriasModel> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "AlumnosSemestresModel{" +
                "anioPeriodo=" + anioPeriodo +
                ", fin='" + fin + '\'' +
                ", materias=" + materias +
                ", periodo='" + periodo + '\'' +
                ", semestre=" + semestre +
                ", semestreid=" + semestreid +
                ", status=" + status +
                ", tipoPeriodoID=" + tipoPeriodoID +
                ", planID=" + planID +
                ", userID=" + userID +
                '}';
    }
}
