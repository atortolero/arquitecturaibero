package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;

@Entity
public class SemestreMaterias {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="semestreMaterias_seq")
    @SequenceGenerator(name = "semestreMaterias_seq", sequenceName = "semestreMaterias_seq", initialValue = 1, allocationSize=1)
    @Column(name="id")
    private long id;

    @Column(name="status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "materiaid")
    private Materias materias;

    @ManyToOne
    @JoinColumn(name = "semestreid")
    private Semestres semestres;

    public SemestreMaterias() {
    }

    public SemestreMaterias(long id, Materias materias, Semestres semestres, int status) {
        this.id = id;
        this.materias = materias;
        this.semestres = semestres;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }

    public Semestres getSemestres() {
        return semestres;
    }

    public void setSemestres(Semestres semestres) {
        this.semestres = semestres;
    }


}
