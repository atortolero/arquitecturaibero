package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="planes")
public class Planes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="planes_seq")
    @SequenceGenerator(name = "planes_seq", sequenceName = "planes_seq", initialValue = 1, allocationSize=1)
    @Column(name="planid")
    private long planid;

    @Column(name="nombre")
    private String nombre;

    @Column(name="numeroOptativas")
    private long numeroOptativas;

    @Column(name="anioInicio")
    private int anioInicio;

    @Column(name="periodoInicioid")
    private int periodoInicioid;

    @Column(name="creditos")
    private long creditos;

    @Column(name="creditosOptativas")
    private long creditosOptativas;

    @Column(name="creditosObligatorias")
    private long creditosObligatorias;

    @Column(name="pdf")
    private String pdf;

    @OneToMany(mappedBy = "planes", cascade = CascadeType.ALL)
    private Set<SecuenciaFormativa> secuenciaFormativaSet;

    @OneToMany(mappedBy = "planes", cascade =  CascadeType.ALL)
    private Set<Materias> materias;

    @OneToMany(mappedBy = "planes", cascade = CascadeType.ALL)
    private Set<Alumnos> alumnos;

    public Planes() {
    }

    public Planes(long planid, String nombre, long numeroOptativas, int anioInicio, int periodoInicioid, long creditos, long creditosOptativas, long creditosObligatorias, String pdf, Set<SecuenciaFormativa> secuenciaFormativaSet, Set<Materias> materias, Set<Alumnos> alumnos) {
        this.planid = planid;
        this.nombre = nombre;
        this.numeroOptativas = numeroOptativas;
        this.anioInicio = anioInicio;
        this.periodoInicioid = periodoInicioid;
        this.creditos = creditos;
        this.creditosOptativas = creditosOptativas;
        this.creditosObligatorias = creditosObligatorias;
        this.pdf = pdf;
        this.secuenciaFormativaSet = secuenciaFormativaSet;
        this.materias = materias;
        this.alumnos = alumnos;
    }

    public long getPlanid() {
        return planid;
    }

    public void setPlanid(long planid) {
        this.planid = planid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNumeroOptativas() {
        return numeroOptativas;
    }

    public void setNumeroOptativas(long numeroOptativas) {
        this.numeroOptativas = numeroOptativas;
    }

    public long getCreditos() {
        return creditos;
    }

    public void setCreditos(long creditos) {
        this.creditos = creditos;
    }

    public long getCreditosOptativas() {
        return creditosOptativas;
    }

    public void setCreditosOptativas(long creditosOptativas) {
        this.creditosOptativas = creditosOptativas;
    }

    public long getCreditosObligatorias() {
        return creditosObligatorias;
    }

    public void setCreditosObligatorias(long creditosObligatorias) {
        this.creditosObligatorias = creditosObligatorias;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public int getPeriodoInicioid() {
        return periodoInicioid;
    }

    public void setPeriodoInicioid(int periodoInicioid) {
        this.periodoInicioid = periodoInicioid;
    }

    public Set<SecuenciaFormativa> getSecuenciaFormativaSet() {
        return secuenciaFormativaSet;
    }

    public void setSecuenciaFormativaSet(Set<SecuenciaFormativa> secuenciaFormativaSet) {
        this.secuenciaFormativaSet = secuenciaFormativaSet;
    }

    public Set<Materias> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materias> materias) {
        this.materias = materias;
    }

    public Set<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
}
