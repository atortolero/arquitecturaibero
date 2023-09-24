package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.Planes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("planesJpaRepository")
public interface PlanesJpaRepository extends JpaRepository<Planes, Serializable> {

    public abstract List<Planes> findAllByOrderByNombre();
    public abstract List<Planes> findAllByPlanidIsNotOrderByNombre(long planid);
    public abstract Planes findByPlanid(long planid);
}
