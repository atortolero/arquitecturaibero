package mx.com.gtsf.arquitecturaibero.model;

public class UsuariosModel {

    private long usuarioid;
    private long admininterno;
    private String password;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String email;
    private int activo;
    private long tipoid;
    private int error;
    private String token;
    private String carrera; //
    private String numCuenta; //
    private long periodoInicioid; //
    private int anioInicio; //
    private String semestre; //
    private long planid; //
    private long expiresin;

    public UsuariosModel() {
    }

    public UsuariosModel(long usuarioid, long admininterno, String password, String nombre, String apPaterno, String apMaterno, String email, int activo, long tipoid, int error, String token, String carrera, String numCuenta, long periodoInicioid, int anioInicio, String semestre, long planid, long expiresin) {
        this.usuarioid = usuarioid;
        this.admininterno = admininterno;
        this.password = password;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.email = email;
        this.activo = activo;
        this.tipoid = tipoid;
        this.error = error;
        this.token = token;
        this.carrera = carrera;
        this.numCuenta = numCuenta;
        this.periodoInicioid = periodoInicioid;
        this.anioInicio = anioInicio;
        this.semestre = semestre;
        this.planid = planid;
        this.expiresin = expiresin;
    }

    public long getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(long usuarioid) {
        this.usuarioid = usuarioid;
    }

    public long getAdmininterno() {
        return admininterno;
    }

    public void setAdmininterno(long admininterno) {
        this.admininterno = admininterno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public long getTipoid() {
        return tipoid;
    }

    public void setTipoid(long tipoid) {
        this.tipoid = tipoid;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresin() {
        return expiresin;
    }

    public void setExpiresin(long expiresin) {
        this.expiresin = expiresin;
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

    public long getPeriodoInicioid() {
        return periodoInicioid;
    }

    public void setPeriodoInicioid(long periodoInicioid) {
        this.periodoInicioid = periodoInicioid;
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
}
