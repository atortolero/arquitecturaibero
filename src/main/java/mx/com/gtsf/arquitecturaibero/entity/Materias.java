package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="materias")
public class Materias {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="materias_seq")
    @SequenceGenerator(name = "materias_seq", sequenceName = "materias_seq", initialValue = 1, allocationSize=1)
    @Column(name="materiaid")
    private long materiaid;

    @Column(name="materia")
    private String materia;

    @Column(name="clave")
    private String clave;

    @Column(name="sigla")
    private String sigla;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="obligatoria")
    private boolean obligatoria;

    @Column(name="verano")
    private boolean verano;

    @Column(name="creditos")
    private int creditos;

    @Column(name="horas")
    private int horas;

    @Column(name="semestreIdeal")
    private int semestreIdeal;

    @Column(name="secuenciaid")
    private long secuenciaid;

    @Column(name="opcionid")
    private long opcionid;

    @ManyToOne
    @JoinColumn(name = "areaid")
    private Areas areas;

    @ManyToOne
    @JoinColumn(name = "planid")
    private Planes planes;

    @OneToMany(mappedBy = "materias")
    private Set<MateriasPrerrequisitos> materiasPrerrequisitos;

    @OneToMany(mappedBy = "materias")
    private Set<SemestreMaterias> semestreMaterias;

    public Materias() {
    }

    public Materias(long materiaid, String materia, String clave, String sigla, String descripcion, boolean obligatoria, boolean verano, int creditos, int horas, int semestreIdeal, long secuenciaid, long opcionid, Areas areas, Planes planes, Set<MateriasPrerrequisitos> materiasPrerrequisitos, Set<SemestreMaterias> semestreMaterias) {
        this.materiaid = materiaid;
        this.materia = materia;
        this.clave = clave;
        this.sigla = sigla;
        this.descripcion = descripcion;
        this.obligatoria = obligatoria;
        this.verano = verano;
        this.creditos = creditos;
        this.horas = horas;
        this.semestreIdeal = semestreIdeal;
        this.secuenciaid = secuenciaid;
        this.opcionid = opcionid;
        this.areas = areas;
        this.planes = planes;
        this.materiasPrerrequisitos = materiasPrerrequisitos;
        this.semestreMaterias = semestreMaterias;
    }

    public long getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(long materiaid) {
        this.materiaid = materiaid;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Areas getAreas() {
        return areas;
    }

    public long getSecuenciaid() {
        return secuenciaid;
    }

    public void setSecuenciaid(long secuenciaid) {
        this.secuenciaid = secuenciaid;
    }

    public long getOpcionid() {
        return opcionid;
    }

    public void setOpcionid(long opcionid) {
        this.opcionid = opcionid;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }

    public Set<MateriasPrerrequisitos> getMateriasPrerrequisitos() {
        return materiasPrerrequisitos;
    }

    public void setMateriasPrerrequisitos(Set<MateriasPrerrequisitos> materiasPrerrequisitos) {
        this.materiasPrerrequisitos = materiasPrerrequisitos;
    }

    public Planes getPlanes() {
        return planes;
    }

    public void setPlanes(Planes planes) {
        this.planes = planes;
    }

    public boolean isVerano() {
        return verano;
    }

    public void setVerano(boolean verano) {
        this.verano = verano;
    }

    public int getSemestreIdeal() {
        return semestreIdeal;
    }

    public void setSemestreIdeal(int semestreIdeal) {
        this.semestreIdeal = semestreIdeal;
    }

    public Set<SemestreMaterias> getSemestreMaterias() {
        return semestreMaterias;
    }

    public void setSemestreMaterias(Set<SemestreMaterias> semestreMaterias) {
        this.semestreMaterias = semestreMaterias;
    }
}
