package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;

@Entity
public class MateriasPrerrequisitos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="materiasprerrequisitos_seq")
    @SequenceGenerator(name = "materiasprerrequisitos_seq", sequenceName = "materiasprerrequisitos_seq", initialValue = 1, allocationSize=1)
    @Column(name="id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "materiaid")
    private Materias materias;

    @ManyToOne
    @JoinColumn(name = "prerrequisitoid")
    private Prerrequisitos prerrequisitos;

    // Atributos adicionales aqui


    public MateriasPrerrequisitos() {
    }

    public MateriasPrerrequisitos(long id, Materias materias, Prerrequisitos prerrequisitos) {
        this.id = id;
        this.materias = materias;
        this.prerrequisitos = prerrequisitos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }

    public Prerrequisitos getPrerrequisitos() {
        return prerrequisitos;
    }

    public void setPrerrequisitos(Prerrequisitos prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }
}
