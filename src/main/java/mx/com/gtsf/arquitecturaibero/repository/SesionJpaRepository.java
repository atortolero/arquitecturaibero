package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("sesionJpaRepository")
public interface SesionJpaRepository extends JpaRepository<Sesion, Serializable> {

    public abstract Sesion findByToken(String token);
    public abstract Sesion findByUsuario_Usuarioid(long usuarioid);
    public abstract List<Sesion> getAllByUsuario_Usuarioid(long usuarioid);

}

