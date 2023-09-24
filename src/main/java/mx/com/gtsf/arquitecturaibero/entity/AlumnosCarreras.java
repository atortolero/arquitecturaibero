package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;

@Entity
public class AlumnosCarreras {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="alumnosCarreras_seq")
    @SequenceGenerator(name = "alumnosCarreras_seq", sequenceName = "alumnosCarreras_seq", initialValue = 1, allocationSize=1)
    @Column(name="id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "alumnoid")
    private Alumnos alumnos;

    @ManyToOne
    @JoinColumn(name = "carreraid")
    private Carreras carreras;

    public AlumnosCarreras() {
    }

    public AlumnosCarreras(long id, Alumnos alumnos, Carreras carreras) {
        this.id = id;
        this.alumnos = alumnos;
        this.carreras = carreras;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Alumnos getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }

    public Carreras getCarreras() {
        return carreras;
    }

    public void setCarreras(Carreras carreras) {
        this.carreras = carreras;
    }
}
