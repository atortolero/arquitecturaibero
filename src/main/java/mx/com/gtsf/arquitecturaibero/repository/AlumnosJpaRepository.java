package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.Alumnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("alumnosJpaRepository")
public interface AlumnosJpaRepository extends JpaRepository<Alumnos, Serializable> {

    public abstract Alumnos getAlumnosByNumCuenta(String numCuenta);
    public abstract Alumnos getAlumnosByAlumnoid(long alumnoid);
}
