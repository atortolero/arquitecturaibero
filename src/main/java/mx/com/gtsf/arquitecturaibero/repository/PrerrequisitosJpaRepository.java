package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.Prerrequisitos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("prerrequisitosJpaRepository")
public interface PrerrequisitosJpaRepository extends JpaRepository<Prerrequisitos, Serializable> {

    public abstract Prerrequisitos findAllByPrerrequisitoid(long prerrequisitoid);

}
