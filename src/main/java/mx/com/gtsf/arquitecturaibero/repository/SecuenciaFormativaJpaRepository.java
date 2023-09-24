package mx.com.gtsf.arquitecturaibero.repository;

import mx.com.gtsf.arquitecturaibero.entity.SecuenciaFormativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("secuenciaFormativaJpaRepository")
public interface SecuenciaFormativaJpaRepository  extends JpaRepository<SecuenciaFormativa, Serializable> {

    public abstract List<SecuenciaFormativa> findAllByPlanes_Planid(long planid);

    public abstract SecuenciaFormativa getSecuenciaFormativaBySecuenciaid(long secuenciaid);

    @Modifying
    @Query("DELETE FROM SecuenciaFormativa sf WHERE sf.planes.planid = :planid")
    public void deleteSecuenciaFormativaByPlanid(@Param("planid") long planid);
}
