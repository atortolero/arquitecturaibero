package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.SemestreMaterias;
import mx.com.gtsf.arquitecturaibero.model.MateriaPrerrequisitoQuery;
import mx.com.gtsf.arquitecturaibero.model.StatusPrerrequisitoQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("semestreMateriasJpaRepository")
public interface SemestreMateriasJpaRepository extends JpaRepository<SemestreMaterias, Serializable> {

    public abstract List<SemestreMaterias> getSemestreMateriasBySemestres_Semestreid(long semestreid);

    public abstract SemestreMaterias findFirstByMaterias_MateriaidOrderByIdDesc(long materiaid);

    public abstract SemestreMaterias findAllByMaterias_MateriaidAndSemestres_Semestreid(long materiaid, long semestreid);

    @Query("SELECT m.materiaid AS id, m.materia AS materia, m.clave AS clave, s.periodo AS periodo, sm.status AS status FROM Alumnos a " +
            "LEFT JOIN Semestres s ON a.alumnoid = s.alumnos.alumnoid " +
            "LEFT JOIN SemestreMaterias sm on s.semestreid = sm.semestres.semestreid " +
            "LEFT JOIN Materias m on sm.materias.materiaid = m.materiaid " +
            "WHERE a.alumnoid = :alumnoid AND m.materiaid = :materiaid ORDER BY s.semestreid DESC")
    List<MateriaPrerrequisitoQuery> getMateriaPrerrequisito(@Param("alumnoid") long alumnoid, @Param("materiaid") long materiaid);


    @Query("SELECT sm.status AS status FROM Semestres s " +
            "LEFT JOIN SemestreMaterias sm ON s.semestreid = sm.semestres.semestreid " +
            "WHERE s.alumnos.alumnoid = :alumnoid AND sm.materias.materiaid = :materiaid ORDER BY sm.semestres.semestreid DESC")
    List<StatusPrerrequisitoQuery> getStatusPrerrequisito(@Param("alumnoid") long alumnoid, @Param("materiaid") long materiaid);


}
