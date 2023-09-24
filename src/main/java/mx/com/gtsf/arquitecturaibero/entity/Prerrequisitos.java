package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="prerrequisitos")
public class Prerrequisitos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="prerrequisitos_seq")
    @SequenceGenerator(name = "prerrequisitos_seq", sequenceName = "prerrequisitos_seq", initialValue = 1, allocationSize=1)
    @Column(name="prerrequisitoid")
    private long prerrequisitoid;

    @Column(name="materiaid")
    private long materiaid;

    @OneToMany(mappedBy = "prerrequisitos")
    private Set<MateriasPrerrequisitos> materiasPrerrequisitos;

    public Prerrequisitos() {
    }

    public Prerrequisitos(long prerrequisitoid, long materiaid, Set<MateriasPrerrequisitos> materiasPrerrequisitos) {
        this.prerrequisitoid = prerrequisitoid;
        this.materiaid = materiaid;
        this.materiasPrerrequisitos = materiasPrerrequisitos;
    }

    public long getPrerrequisitoid() {
        return prerrequisitoid;
    }

    public void setPrerrequisitoid(long prerrequisitoid) {
        this.prerrequisitoid = prerrequisitoid;
    }

    public long getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(long materiaid) {
        this.materiaid = materiaid;
    }

    public Set<MateriasPrerrequisitos> getMateriasPrerrequisitos() {
        return materiasPrerrequisitos;
    }

    public void setMateriasPrerrequisitos(Set<MateriasPrerrequisitos> materiasPrerrequisitos) {
        this.materiasPrerrequisitos = materiasPrerrequisitos;
    }
}
