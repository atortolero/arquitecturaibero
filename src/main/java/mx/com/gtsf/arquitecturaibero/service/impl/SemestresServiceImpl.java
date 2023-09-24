package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.entity.Semestres;
import mx.com.gtsf.arquitecturaibero.repository.SemestresJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.SemestresService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("semestresServiceImpl")
public class SemestresServiceImpl implements SemestresService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AreasServiceImpl.class);

    @Autowired
    @Qualifier("semestresJpaRepository")
    SemestresJpaRepository semestresJpaRepository;

    @Override
    public List<Semestres> getSemestreByAlumnoid(long alumnoid) {

        List<Semestres> semestres = semestresJpaRepository.getSemestresByAlumnos_Alumnoid(alumnoid);
        return semestres;
    }

    @Override
    @Transactional
    public int removeSemestreByAlumnoid(long alumnoid) {

        semestresJpaRepository.deleteSemestres(alumnoid);
        return 0;
    }

    @Override
    public Semestres findLastSemestreByAlumnoid(long alumnoid) {

        Semestres semestre = semestresJpaRepository.findFirstByAlumnos_AlumnoidOrderBySemestreidDesc(alumnoid);
        return semestre;
    }

    @Override
    public Semestres saveSemestre(Semestres semestre) {

        semestre = semestresJpaRepository.save(semestre);

        return semestre;
    }
}
