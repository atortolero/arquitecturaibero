package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="carreras")
public class Carreras {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="carreras_seq")
    @SequenceGenerator(name = "carreras_seq", sequenceName = "carreras_seq", initialValue = 1, allocationSize=1)
    @Column(name="carreraid")
    private long carreraid;

    @Column(name="carrera")
    private String carrera;

    @OneToMany(mappedBy = "carreras")
    private Set<AlumnosCarreras> alumnosCarreras;

    public Carreras(long carreraid, String carrera, Set<AlumnosCarreras> alumnosCarreras) {
        this.carreraid = carreraid;
        this.carrera = carrera;
        this.alumnosCarreras = alumnosCarreras;
    }

    public Carreras() {
    }

    public long getCarreraid() {
        return carreraid;
    }

    public void setCarreraid(long carreraid) {
        this.carreraid = carreraid;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Set<AlumnosCarreras> getAlumnosCarreras() {
        return alumnosCarreras;
    }

    public void setAlumnosCarreras(Set<AlumnosCarreras> alumnosCarreras) {
        this.alumnosCarreras = alumnosCarreras;
    }
}
