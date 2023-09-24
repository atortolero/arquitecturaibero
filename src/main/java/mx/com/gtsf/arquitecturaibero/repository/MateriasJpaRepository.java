package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.Materias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("materiasJpaRepository")
public interface MateriasJpaRepository extends JpaRepository<Materias, Serializable> {

    public abstract List<Materias> findAllByOrderByMateria();

    public abstract Materias findAllByMateriaid(long materiaid);

    public abstract List<Materias> findAllByPlanes_Planid(long planid);

    public abstract List<Materias> findAllBySecuenciaid(long secuenciaid);
}
