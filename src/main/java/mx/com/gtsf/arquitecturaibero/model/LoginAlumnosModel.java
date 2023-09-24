package mx.com.gtsf.arquitecturaibero.model;

public class LoginAlumnosModel {

    private long tipoid;
    private String carrera;
    private String numCuenta;
    private long periodoInicioID;
    private int anioInicio;
    private String semestre;
    private long planid;


    public LoginAlumnosModel() {
    }

    public LoginAlumnosModel(long tipoid, String carrera, String numCuenta, long periodoInicioID, int anioInicio, String semestre, long planid) {
        this.tipoid = tipoid;
        this.carrera = carrera;
        this.numCuenta = numCuenta;
        this.periodoInicioID = periodoInicioID;
        this.anioInicio = anioInicio;
        this.semestre = semestre;
        this.planid = planid;
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

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public long getPlanid() {
        return planid;
    }

    public void setPlanid(long planid) {
        this.planid = planid;
    }

    @Override
    public String toString() {
        return "LoginAlumnosModel{" +
                "tipoid=" + tipoid +
                ", carrera='" + carrera + '\'' +
                ", numCuenta='" + numCuenta + '\'' +
                ", periodoInicioID=" + periodoInicioID +
                ", anioInicio=" + anioInicio +
                ", semestre='" + semestre + '\'' +
                ", planid=" + planid +
                '}';
    }
}
