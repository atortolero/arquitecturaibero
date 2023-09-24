package mx.com.gtsf.arquitecturaibero.repository;


import mx.com.gtsf.arquitecturaibero.entity.Areas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("areasJpaRepository")
public interface AreasJpaRepository extends JpaRepository<Areas, Serializable> {

    public abstract List<Areas> findAllByOrderByArea();
    public abstract Areas getAreasByAreaid(long areaid);

}
