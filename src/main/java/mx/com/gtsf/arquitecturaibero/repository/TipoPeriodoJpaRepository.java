package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.TipoPeriodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("tipoPeriodoJpaRepository")
public interface TipoPeriodoJpaRepository extends JpaRepository<TipoPeriodo, Serializable> {

    public abstract TipoPeriodo getTipoPeriodoByTipoperiodoid(long id);
}
