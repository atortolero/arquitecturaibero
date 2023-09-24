package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.TipoUsuario;
import mx.com.gtsf.arquitecturaibero.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("usuariosJpaRepository")
public interface UsuariosJpaRepository extends JpaRepository<Usuarios, Serializable> {

    public abstract Usuarios findByEmail(String email);

    public abstract List<Usuarios> findUsuariosByTipoUsuario_TipoidOrderByAppaterno(long tipoid);

    public abstract List<Usuarios> findUsuariosByTipoUsuarioOrderByAppaterno(TipoUsuario tipoUsuario);

    public abstract Usuarios findUsuariosByUsuarioid(long usuarioid);

    public abstract Usuarios findTopByOrderByUsuarioidDesc();

    @Modifying
    @Query("DELETE FROM Usuarios u WHERE u.usuarioid = :usuarioid")
    public void deleteUsuario(@Param("usuarioid") long usuarioid);
}