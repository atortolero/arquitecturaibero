package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.entity.Opciones;
import mx.com.gtsf.arquitecturaibero.repository.OpcionesJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.OpcionesService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("opcionesServiceImpl")
public class OpcionesServiceImpl implements OpcionesService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AreasServiceImpl.class);

    @Autowired
    @Qualifier("opcionesJpaRepository")
    OpcionesJpaRepository opcionesJpaRepository;

    @Override
    public List<Opciones> getOpcionesBySecuenciaid(long secuenciaid) {

        List<Opciones> opciones = opcionesJpaRepository.findAllBySecuenciaFormativa_Secuenciaid(secuenciaid);
        return opciones;
    }

    @Override
    public Opciones getOpcionById(long opcionid) {
        try{
            Opciones opcion = opcionesJpaRepository.getOpcionesByOpcionid(opcionid);
            return opcion;
        }catch(Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    public Opciones saveOpcion(Opciones opcion) {

        opcion = opcionesJpaRepository.save(opcion);

        return opcion;
    }
}
