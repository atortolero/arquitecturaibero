package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="semestres")
public class Semestres {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="semestres_seq")
    @SequenceGenerator(name = "semestres_seq", sequenceName = "semestres_seq", initialValue = 1, allocationSize=1)
    @Column(name="semestreid")
    private long semestreid;

    @Column(name="status")
    private int status;

    @Column(name="semestre")
    private String semestre;

    @Column(name="anioPeriodo")
    private int anioPeriodo;

    @Column(name="fin")
    private String fin;

    @Column(name="periodo")
    private String periodo;

    @ManyToOne
    @JoinColumn(name = "tipoperiodoid")
    private TipoPeriodo tipoPeriodo;

    @ManyToOne
    @JoinColumn(name = "alumnoid")
    private Alumnos alumnos;

    @OneToMany(mappedBy = "semestres")
    private Set<SemestreMaterias> semestreMaterias;

    public Semestres(long semestreid, int status, String semestre, int anioPeriodo, String fin, String periodo, TipoPeriodo tipoPeriodo, Alumnos alumnos, Set<SemestreMaterias> semestreMaterias) {
        this.semestreid = semestreid;
        this.status = status;
        this.semestre = semestre;
        this.anioPeriodo = anioPeriodo;
        this.fin = fin;
        this.periodo = periodo;
        this.tipoPeriodo = tipoPeriodo;
        this.alumnos = alumnos;
        this.semestreMaterias = semestreMaterias;
    }

    public Semestres() {
    }

    public long getSemestreid() {
        return semestreid;
    }

    public void setSemestreid(long semestreid) {
        this.semestreid = semestreid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
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

    public TipoPeriodo getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public Alumnos getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }

    public Set<SemestreMaterias> getSemestreMaterias() {
        return semestreMaterias;
    }

    public void setSemestreMaterias(Set<SemestreMaterias> semestreMaterias) {
        this.semestreMaterias = semestreMaterias;
    }
}
