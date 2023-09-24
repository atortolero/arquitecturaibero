package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.component.PrerrequisitosConverter;
import mx.com.gtsf.arquitecturaibero.entity.Prerrequisitos;
import mx.com.gtsf.arquitecturaibero.model.PrerrequisitosModel;
import mx.com.gtsf.arquitecturaibero.repository.PrerrequisitosJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.PrerrequisitosService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("prerrequisitosServiceImpl")
public class PrerrequisitosServiceImpl implements PrerrequisitosService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AreasServiceImpl.class);

    @Autowired
    @Qualifier("prerrequisitosJpaRepository")
    PrerrequisitosJpaRepository prerrequisitosJpaRepository;

    @Autowired
    @Qualifier("prerrequisitosConverter")
    PrerrequisitosConverter prerrequisitosConverter;

    @Override
    public Prerrequisitos getPrerrequisitoById(long prerrequisitoid) {
        try{
            Prerrequisitos prerrequisito = prerrequisitosJpaRepository.findAllByPrerrequisitoid(prerrequisitoid);
            return prerrequisito;
        }catch(Exception e){
            return null;
        }
    }

    @Transactional
    @Override
    public Prerrequisitos addPrerrequisito(PrerrequisitosModel model) {

        Prerrequisitos prerrequisitos = prerrequisitosConverter.convertPrerrequisitosModelToPrerrequisitos(model);
        prerrequisitos = prerrequisitosJpaRepository.save(prerrequisitos);

        return prerrequisitos;
    }

    @Transactional
    @Override
    public int removePrerrequisito(long id) {
        prerrequisitosJpaRepository.deleteById(id);
        return 0;
    }
}
