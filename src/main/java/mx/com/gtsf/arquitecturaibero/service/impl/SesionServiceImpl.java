package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.entity.Sesion;
import mx.com.gtsf.arquitecturaibero.repository.SesionJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.SesionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sesionServiceImpl")
public class SesionServiceImpl implements SesionService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(SesionServiceImpl.class);

    @Autowired
    @Qualifier("sesionJpaRepository")
    SesionJpaRepository sesionJpaRepository;

    @Override
    public List<Sesion> listAllSessions() {

        return sesionJpaRepository.findAll();
    }

    @Override
    public Sesion getSessionByToken(String token) {

        return sesionJpaRepository.findByToken(token);
    }

    @Override
    public List<Sesion> getSessionByUserId(long usuarioid) {
        return sesionJpaRepository.getAllByUsuario_Usuarioid(usuarioid);
    }

    @Override
    public Sesion addSession(Sesion session) {

        return sesionJpaRepository.save(session);
    }

    @Override
    public int removeSession(String token) {
        Sesion sesion = sesionJpaRepository.findByToken(token);
        sesionJpaRepository.delete(sesion);
        return 0;
    }

    @Override
    public int removeSessionByUserId(long userid) {
        Sesion sesion = sesionJpaRepository.findByUsuario_Usuarioid(userid);
        sesionJpaRepository.delete(sesion);
        return 0;
    }

    @Override
    public Sesion updateSession(Sesion session) {

        return sesionJpaRepository.save(session);
    }

    @Override
    public boolean validSession(String token) {
        Sesion sesion = sesionJpaRepository.findByToken(token);

        if(sesion != null){
            return true;
        }
        else {
            return false;
        }
    }
}

