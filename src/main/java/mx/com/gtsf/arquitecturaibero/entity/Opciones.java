package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="opciones")
public class Opciones {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="opciones_seq")
    @SequenceGenerator(name = "opciones_seq", sequenceName = "opciones_seq", initialValue = 1, allocationSize=1)
    @Column(name="opcionid")
    private long opcionid;

    @Column(name="opcion")
    private String opcion;

    @ManyToOne
    @JoinColumn(name = "secuenciaid")
    private SecuenciaFormativa secuenciaFormativa;

    public Opciones() {
    }

    public Opciones(long opcionid, String opcion, SecuenciaFormativa secuenciaFormativa) {
        this.opcionid = opcionid;
        this.opcion = opcion;
        this.secuenciaFormativa = secuenciaFormativa;
    }

    public long getOpcionid() {
        return opcionid;
    }

    public void setOpcionid(long opcionid) {
        this.opcionid = opcionid;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public SecuenciaFormativa getSecuenciaFormativa() {
        return secuenciaFormativa;
    }

    public void setSecuenciaFormativa(SecuenciaFormativa secuenciaFormativa) {
        this.secuenciaFormativa = secuenciaFormativa;
    }

}
