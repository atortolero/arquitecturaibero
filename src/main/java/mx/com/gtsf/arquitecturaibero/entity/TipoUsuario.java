package mx.com.gtsf.arquitecturaibero.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tipousuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tipousuario_seq")
    @SequenceGenerator(name = "tipousuario_seq", sequenceName = "tipousuario_seq", initialValue = 1, allocationSize=1)
    @Column(name="tipoid")
    private long tipoid;

    @Column(name="descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "tipoUsuario", cascade = CascadeType.ALL)
    private Set<Usuarios> usuarios;

    public TipoUsuario() {
    }

    public TipoUsuario(long tipoid, String descripcion, Set<Usuarios> usuarios) {
        this.tipoid = tipoid;
        this.descripcion = descripcion;
        this.usuarios = usuarios;
    }

    public long getTipoid() {
        return tipoid;
    }

    public void setTipoid(long tipoid) {
        this.tipoid = tipoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
}
