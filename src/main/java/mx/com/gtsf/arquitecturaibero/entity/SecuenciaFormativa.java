package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="secuenciaformativa")
public class SecuenciaFormativa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="secuenciaformativa_seq")
    @SequenceGenerator(name = "secuenciaformativa_seq", sequenceName = "secuenciaformativa_seq", initialValue = 1, allocationSize=1)
    @Column(name="secuenciaid")
    private long secuenciaid;

    @Column(name="secuencia")
    private String secuencia;

    @Column(name="materiasOptativas")
    private long materiasOptativas;

    @Column(name="materiasObligatorias")
    private long materiasObligatorias;

    @Column(name="leyenda")
    private String leyenda;

    @ManyToOne
    @JoinColumn(name = "planid")
    private Planes planes;

    @OneToMany(mappedBy = "secuenciaFormativa", cascade = CascadeType.ALL)
    private Set<Opciones> opciones;

    public SecuenciaFormativa() {
    }

    public SecuenciaFormativa(long secuenciaid, String secuencia, long materiasOptativas, long materiasObligatorias, String leyenda, Planes planes, Set<Opciones> opciones) {
        this.secuenciaid = secuenciaid;
        this.secuencia = secuencia;
        this.materiasOptativas = materiasOptativas;
        this.materiasObligatorias = materiasObligatorias;
        this.leyenda = leyenda;
        this.planes = planes;
        this.opciones = opciones;
    }

    public long getSecuenciaid() {
        return secuenciaid;
    }

    public void setSecuenciaid(long secuenciaid) {
        this.secuenciaid = secuenciaid;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public long getMateriasOptativas() {
        return materiasOptativas;
    }

    public void setMateriasOptativas(long materiasOptativas) {
        this.materiasOptativas = materiasOptativas;
    }

    public long getMateriasObligatorias() {
        return materiasObligatorias;
    }

    public void setMateriasObligatorias(long materiasObligatorias) {
        this.materiasObligatorias = materiasObligatorias;
    }

    public Planes getPlanes() {
        return planes;
    }

    public void setPlanes(Planes planes) {
        this.planes = planes;
    }

    public Set<Opciones> getOpciones() {
        return opciones;
    }

    public void setOpciones(Set<Opciones> opciones) {
        this.opciones = opciones;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }
}
