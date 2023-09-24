package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="areas")
public class Areas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="area_seq")
    @SequenceGenerator(name = "area_seq", sequenceName = "area_seq", initialValue = 1, allocationSize=1)
    @Column(name="areaid")
    private long areaid;

    @Column(name="color")
    private String color;

    @Column(name="area")
    private String area;

    @OneToMany(mappedBy = "areas", cascade =  CascadeType.ALL)
    private Set<Materias> materias;

    public Areas() {
    }

    public Areas(long areaid, String color, String area, Set<Materias> materias) {
        this.areaid = areaid;
        this.color = color;
        this.area = area;
        this.materias = materias;
    }

    public long getAreaid() {
        return areaid;
    }

    public void setAreaid(long areaid) {
        this.areaid = areaid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Set<Materias> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materias> materias) {
        this.materias = materias;
    }
}
