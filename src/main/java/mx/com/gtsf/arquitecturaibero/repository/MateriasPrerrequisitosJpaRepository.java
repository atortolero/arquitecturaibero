package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.MateriasPrerrequisitos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("materiasPrerrequisitosJpaRepository")
public interface MateriasPrerrequisitosJpaRepository extends JpaRepository<MateriasPrerrequisitos, Serializable> {

    public abstract List<MateriasPrerrequisitos> findAllByMaterias_Materiaid(long materiaid);

    @Modifying
    @Query("DELETE FROM MateriasPrerrequisitos mp WHERE mp.materias.materiaid = :materiaid")
    public void deleteMateriasPrerrequisitosByMateriaid(@Param("materiaid") long materiaid);
}
