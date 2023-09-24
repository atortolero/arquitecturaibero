package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.Opciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("opcionesJpaRepository")
public interface OpcionesJpaRepository extends JpaRepository<Opciones, Serializable> {

    public abstract List<Opciones> findAllBySecuenciaFormativa_Secuenciaid(long secuenciaid);

    public abstract Opciones getOpcionesByOpcionid(long opcionid);
}
