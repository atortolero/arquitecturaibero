package mx.com.gtsf.arquitecturaibero.model;

import java.util.List;

public class    AlumnosModel {

    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private long tipoid;
    private String carrera;
    private String numCuenta;
    private long periodoInicioID;
    private int anioInicio;
    //private String semestre;
    private long planid;
    List<AlumnosSemestresModel> semestres;

    public AlumnosModel() {
    }

    public AlumnosModel(String nombre, String apPaterno, String apMaterno, long tipoid, String carrera, String numCuenta, long periodoInicioID, int anioInicio, long planid, List<AlumnosSemestresModel> semestres) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.tipoid = tipoid;
        this.carrera = carrera;
        this.numCuenta = numCuenta;
        this.periodoInicioID = periodoInicioID;
        this.anioInicio = anioInicio;
        this.planid = planid;
        this.semestres = semestres;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public long getTipoid() {
        return tipoid;
    }

    public void setTipoid(long tipoid) {
        this.tipoid = tipoid;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public long getPeriodoInicioID() {
        return periodoInicioID;
    }

    public void setPeriodoInicioID(long periodoInicioID) {
        this.periodoInicioID = periodoInicioID;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

//    public String getSemestre() {
//        return semestre;
//    }
//
//    public void setSemestre(String semestre) {
//        this.semestre = semestre;
//    }

    public long getPlanid() {
        return planid;
    }

    public void setPlanid(long planid) {
        this.planid = planid;
    }

    public List<AlumnosSemestresModel> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<AlumnosSemestresModel> semestres) {
        this.semestres = semestres;
    }

    @Override
    public String toString() {
        return "AlumnosModel{" +
                "nombre='" + nombre + '\'' +
                ", apPaterno='" + apPaterno + '\'' +
                ", apMaterno='" + apMaterno + '\'' +
                ", tipoid=" + tipoid +
                ", carrera='" + carrera + '\'' +
                ", numCuenta='" + numCuenta + '\'' +
                ", periodoInicioID=" + periodoInicioID +
                ", anioInicio=" + anioInicio +
                ", planid=" + planid +
                ", semestres=" + semestres +
                '}';
    }
}
