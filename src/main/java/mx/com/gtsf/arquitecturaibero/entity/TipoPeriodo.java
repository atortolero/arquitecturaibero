package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tipoPeriodo")
public class TipoPeriodo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tipoPeriodo_seq")
    @SequenceGenerator(name = "tipoPeriodo_seq", sequenceName = "tipoPeriodo_seq", initialValue = 1, allocationSize=1)
    @Column(name="tipoperiodoid")
    private long tipoperiodoid;

    @Column(name="periodo")
    private String periodo;

    @OneToMany(mappedBy = "tipoPeriodo", cascade = CascadeType.ALL)
    private Set<Alumnos> alumnos;

    @OneToMany(mappedBy = "tipoPeriodo", cascade = CascadeType.ALL)
    private Set<Semestres> semestres;

    public TipoPeriodo() {
    }

    public TipoPeriodo(long tipoperiodoid, String periodo, Set<Alumnos> alumnos, Set<Semestres> semestres) {
        this.tipoperiodoid = tipoperiodoid;
        this.periodo = periodo;
        this.alumnos = alumnos;
        this.semestres = semestres;
    }

    public long getTipoperiodoid() {
        return tipoperiodoid;
    }

    public void setTipoperiodoid(long tipoperiodoid) {
        this.tipoperiodoid = tipoperiodoid;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Set<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Semestres> getSemestres() {
        return semestres;
    }

    public void setSemestres(Set<Semestres> semestres) {
        this.semestres = semestres;
    }
}
