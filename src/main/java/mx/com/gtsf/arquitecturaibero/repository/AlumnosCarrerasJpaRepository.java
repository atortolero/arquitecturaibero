package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.AlumnosCarreras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("alumnosCarrerasJpaRepository")
public interface AlumnosCarrerasJpaRepository extends JpaRepository<AlumnosCarreras, Serializable> {

    public abstract List<AlumnosCarreras> getAlumnosCarrerasByAlumnos_Alumnoid(long alumnoid);

}
