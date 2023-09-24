package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("tipoUsuarioJpaRepository")
public interface TipoUsuarioJpaRepository extends JpaRepository<TipoUsuario, Serializable> {

    public abstract TipoUsuario findByTipoid(long tipoid);
    public abstract List<TipoUsuario> findAllByOrderByDescripcion();
    public abstract List<TipoUsuario> findTipoUsuarioByTipoidIsNotLikeOrderByDescripcion(long tipoid);

}
