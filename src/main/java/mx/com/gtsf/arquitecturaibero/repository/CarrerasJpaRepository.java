package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.Carreras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("carrerasJpaRepository")
public interface CarrerasJpaRepository extends JpaRepository<Carreras, Serializable> {

    public abstract Carreras getAllByCarreraid(long carreraid);
    public abstract Carreras getAllByCarrera(String carrera);

}
