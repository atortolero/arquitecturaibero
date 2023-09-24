package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.Semestres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("semestresJpaRepository")
public interface SemestresJpaRepository extends JpaRepository<Semestres, Serializable> {

    public abstract List<Semestres> getSemestresByAlumnos_Alumnoid(long alumnoid);

    public abstract Semestres findFirstByAlumnos_AlumnoidOrderBySemestreidDesc(long alumnoid);

    @Modifying
    @Query("DELETE FROM Semestres s WHERE s.alumnos.alumnoid = :alumnoid")
    public void deleteSemestres(@Param("alumnoid") long alumnoid);


}
