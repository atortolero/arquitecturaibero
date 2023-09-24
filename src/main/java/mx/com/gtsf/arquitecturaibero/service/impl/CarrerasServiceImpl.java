package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.entity.Carreras;
import mx.com.gtsf.arquitecturaibero.repository.CarrerasJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.CarrerasService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("carrerasServiceImpl")
public class CarrerasServiceImpl implements CarrerasService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AreasServiceImpl.class);

    @Autowired
    @Qualifier("carrerasJpaRepository")
    CarrerasJpaRepository carrerasJpaRepository;

    @Override
    public Carreras getCarreraByid(long id) {
        Carreras carrera = carrerasJpaRepository.getAllByCarreraid(id);
        return carrera;
    }

    @Override
    public Carreras getCarreraByName(String nombreCarrera) {

        Carreras carrera = carrerasJpaRepository.getAllByCarrera(nombreCarrera);
        return carrera;
    }
}
