package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.entity.SemestreMaterias;
import mx.com.gtsf.arquitecturaibero.model.MateriaPrerrequisitoQuery;
import mx.com.gtsf.arquitecturaibero.model.StatusPrerrequisitoQuery;
import mx.com.gtsf.arquitecturaibero.repository.SemestreMateriasJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.SemestreMateriasService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("semestreMateriasServiceImpl")
public class SemestreMateriasServiceImpl implements SemestreMateriasService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AreasServiceImpl.class);

    @Autowired
    @Qualifier("semestreMateriasJpaRepository")
    SemestreMateriasJpaRepository semestreMateriasJpaRepository;

    @Override
    public List<SemestreMaterias> getSemestreMateriasBySemestreid(long semestreid) {

        List<SemestreMaterias> semestreMaterias = semestreMateriasJpaRepository.getSemestreMateriasBySemestres_Semestreid(semestreid);

        return semestreMaterias;
    }

    @Override
    public MateriaPrerrequisitoQuery getMateriaPrerrequisito(long alumnoid, long materiaid) {
        MateriaPrerrequisitoQuery materiaPrerrequisitoQuery;

        //LOG.info("en getMateriaPrerrequisito con: alumnoid: " + alumnoid + "y materiaid: " + materiaid);

        List<MateriaPrerrequisitoQuery> materiasPrerrequisitosQuery = semestreMateriasJpaRepository.getMateriaPrerrequisito(alumnoid, materiaid);

        try {
            materiaPrerrequisitoQuery = materiasPrerrequisitosQuery.get(0);
        }catch(Exception e){
            // El alumno no ha llevado esa materia
            materiaPrerrequisitoQuery = null;
        }

        return materiaPrerrequisitoQuery;
    }

    @Override
    public SemestreMaterias saveSemestreMaterias(SemestreMaterias semestreMaterias) {

        semestreMaterias = semestreMateriasJpaRepository.save(semestreMaterias);

        return semestreMaterias;
    }

    @Override
    public int getStatusPrerrequisito(long alumnoid, long materiaid) {

        List<StatusPrerrequisitoQuery> statusPrerrequisitoQuery = semestreMateriasJpaRepository.getStatusPrerrequisito(alumnoid, materiaid);

        if(statusPrerrequisitoQuery != null) {
            return statusPrerrequisitoQuery.get(0).getStatus();
        }
        else{ // la materia no tiene prerrequisito
            LOG.info("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
            LOG.info("Alumnoid: " + alumnoid + " materiaid: " + materiaid + " ");
            LOG.info("La materia no tiene status");
            LOG.info("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
            return 0;
        }
    }
}
