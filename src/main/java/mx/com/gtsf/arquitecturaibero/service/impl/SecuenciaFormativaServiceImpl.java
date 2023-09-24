package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.entity.SecuenciaFormativa;
import mx.com.gtsf.arquitecturaibero.model.SecuenciasFormativasModel;
import mx.com.gtsf.arquitecturaibero.repository.SecuenciaFormativaJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.SecuenciaFormativaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("secuenciaFormativaServiceImpl")
public class SecuenciaFormativaServiceImpl implements SecuenciaFormativaService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(SecuenciaFormativaServiceImpl.class);

    @Autowired
    @Qualifier("secuenciaFormativaJpaRepository")
    SecuenciaFormativaJpaRepository secuenciaFormativaJpaRepository;

    @Override
    public List<SecuenciaFormativa> getSecuenciasbyPlanid(long planid) {

        List<SecuenciaFormativa> secuenciasFormativas = secuenciaFormativaJpaRepository.findAllByPlanes_Planid(planid);
        return secuenciasFormativas;
    }

    @Override
    public SecuenciaFormativa getSecuenciaById(long secuenciaid) {

        try {
            SecuenciaFormativa secuencia = secuenciaFormativaJpaRepository.getSecuenciaFormativaBySecuenciaid(secuenciaid);
            return secuencia;
        }catch(Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    public SecuenciaFormativa saveSecuenciaFormativa(SecuenciaFormativa secuenciaFormativa) {

        secuenciaFormativa = secuenciaFormativaJpaRepository.save(secuenciaFormativa);
        return secuenciaFormativa;
    }

    @Transactional
    @Override
    public int removeSecuenciaFormativa(long secuenciaid) {
        secuenciaFormativaJpaRepository.deleteById(secuenciaid);
        return 0;
    }

    @Transactional
    @Override
    public int removeSecuenciaFormataivaByPlanid(long planid) {
        secuenciaFormativaJpaRepository.deleteSecuenciaFormativaByPlanid(planid);
        return 0;
    }
}
