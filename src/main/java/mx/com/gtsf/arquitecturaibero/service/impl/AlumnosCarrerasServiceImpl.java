package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.entity.Alumnos;
import mx.com.gtsf.arquitecturaibero.entity.AlumnosCarreras;
import mx.com.gtsf.arquitecturaibero.repository.AlumnosCarrerasJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.AlumnosCarrerasService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("alumnosCarrerasServiceImpl")
public class AlumnosCarrerasServiceImpl implements AlumnosCarrerasService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AreasServiceImpl.class);

    @Autowired
    @Qualifier("alumnosCarrerasJpaRepository")
    AlumnosCarrerasJpaRepository alumnosCarrerasJpaRepository;

    @Override
    public AlumnosCarreras getCarrerasByAlumnoid(long alumnoid) {

        List<AlumnosCarreras> alumnosCarreras = alumnosCarrerasJpaRepository.getAlumnosCarrerasByAlumnos_Alumnoid(alumnoid);

        if(alumnosCarreras.size() > 0){
            return alumnosCarreras.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public AlumnosCarreras saveAlumnosCarreras(AlumnosCarreras alumnosCarreras) {

        alumnosCarreras = alumnosCarrerasJpaRepository.save(alumnosCarreras);
        return alumnosCarreras;
    }
}
