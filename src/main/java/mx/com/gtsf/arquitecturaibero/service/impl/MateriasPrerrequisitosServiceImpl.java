package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.entity.MateriasPrerrequisitos;
import mx.com.gtsf.arquitecturaibero.repository.MateriasPrerrequisitosJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.MateriasPrerrequisitosService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("materiasPrerrequisitosServiceImpl")
public class MateriasPrerrequisitosServiceImpl implements MateriasPrerrequisitosService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(MateriasPrerrequisitosServiceImpl.class);

    @Autowired
    @Qualifier("materiasPrerrequisitosJpaRepository")
    MateriasPrerrequisitosJpaRepository materiasPrerrequisitosJpaRepository;

    @Override
    public List<MateriasPrerrequisitos> getPrerrequisitosByMateriaid(long materiaid) {

        try {
            List<MateriasPrerrequisitos> materiasPrerrequisitos = materiasPrerrequisitosJpaRepository.findAllByMaterias_Materiaid(materiaid);
            return materiasPrerrequisitos;
        }catch(Exception e){
            return null;
        }
    }

    @Transactional
    @Override
    public MateriasPrerrequisitos addMateriasPrerrequisitos(MateriasPrerrequisitos materiasPrerrequisitos) {
        materiasPrerrequisitos = materiasPrerrequisitosJpaRepository.save(materiasPrerrequisitos);
        return materiasPrerrequisitos;
    }

    @Transactional
    @Override
    public int removeMateriasPrerrequisitosByMateriaid(long materiaid) {

        materiasPrerrequisitosJpaRepository.deleteMateriasPrerrequisitosByMateriaid(materiaid);
        return 0;
    }
}
