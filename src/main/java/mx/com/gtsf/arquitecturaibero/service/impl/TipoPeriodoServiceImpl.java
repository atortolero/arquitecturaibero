package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.entity.TipoPeriodo;
import mx.com.gtsf.arquitecturaibero.repository.TipoPeriodoJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.TipoPeriodoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("tipoPeriodoServiceImpl")
public class TipoPeriodoServiceImpl implements TipoPeriodoService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AreasServiceImpl.class);

    @Autowired
    @Qualifier("tipoPeriodoJpaRepository")
    TipoPeriodoJpaRepository tipoPeriodoJpaRepository;

    @Override
    public TipoPeriodo getTipoPeriodoById(long id) {

        TipoPeriodo tipoPeriodo = null;

        try{
            tipoPeriodo = tipoPeriodoJpaRepository.getTipoPeriodoByTipoperiodoid(id);
        }catch(Exception e){
            LOG.info("Error al obtener el tipo Periodo");
        }

        return tipoPeriodo;
    }
}
