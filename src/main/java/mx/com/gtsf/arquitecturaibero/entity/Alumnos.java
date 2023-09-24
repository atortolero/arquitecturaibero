package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="alumnos")
public class Alumnos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="alumnos_seq")
    @SequenceGenerator(name = "alumnos_seq", sequenceName = "alumnos_seq", initialValue = 1, allocationSize=1)
    @Column(name="alumnoid")
    private long alumnoid;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apPaterno")
    private String apPaterno;

    @Column(name="apMaterno")
    private String apMaterno;

    @Column(name="numCuenta")
    private String numCuenta;

    @Column(name="anioInicio")
    private int anioInicio;

    @ManyToOne
    @JoinColumn(name = "planid")
    private Planes planes;

    @ManyToOne
    @JoinColumn(name = "tipoperiodoid")
    private TipoPeriodo tipoPeriodo;

    @OneToMany(mappedBy = "alumnos")
    private Set<AlumnosCarreras> alumnosCarreras;

    @OneToMany(mappedBy = "alumnos")
    private Set<Semestres> semestres;

    public Alumnos(long alumnoid, String nombre, String apPaterno, String apMaterno, String numCuenta, int anioInicio, Planes planes, TipoPeriodo tipoPeriodo, Set<AlumnosCarreras> alumnosCarreras, Set<Semestres> semestres) {
        this.alumnoid = alumnoid;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.numCuenta = numCuenta;
        this.anioInicio = anioInicio;
        this.planes = planes;
        this.tipoPeriodo = tipoPeriodo;
        this.alumnosCarreras = alumnosCarreras;
        this.semestres = semestres;
    }

    public Alumnos() {
    }

    public long getAlumnoid() {
        return alumnoid;
    }

    public void setAlumnoid(long alumnoid) {
        this.alumnoid = alumnoid;
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

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Planes getPlanes() {
        return planes;
    }

    public void setPlanes(Planes planes) {
        this.planes = planes;
    }

    public TipoPeriodo getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public Set<AlumnosCarreras> getAlumnosCarreras() {
        return alumnosCarreras;
    }

    public void setAlumnosCarreras(Set<AlumnosCarreras> alumnosCarreras) {
        this.alumnosCarreras = alumnosCarreras;
    }

    public Set<Semestres> getSemestres() {
        return semestres;
    }

    public void setSemestres(Set<Semestres> semestres) {
        this.semestres = semestres;
    }
}
