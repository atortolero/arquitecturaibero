package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.component.TipoUsuarioConverter;
import mx.com.gtsf.arquitecturaibero.entity.TipoUsuario;
import mx.com.gtsf.arquitecturaibero.model.TipoUsuarioModel;
import mx.com.gtsf.arquitecturaibero.repository.TipoUsuarioJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.TipoUsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("tipoUsuarioServiceImpl")
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(TipoUsuarioServiceImpl.class);

    @Autowired
    @Qualifier("tipoUsuarioJpaRepository")
    TipoUsuarioJpaRepository tipoUsuarioJpaRepository;

    @Autowired
    @Qualifier("tipoUsuarioConverter")
    TipoUsuarioConverter tipoUsuarioConverter;

    private List<TipoUsuarioModel> convertTipoUsuarioToTipoUsuarioModel(List<TipoUsuario> tiposUsuario){
        List<TipoUsuarioModel> tiposUsuarioModel = new ArrayList<TipoUsuarioModel>();

        for (TipoUsuario tipoUsuario: tiposUsuario) {

            TipoUsuarioModel tipoUsuarioModel = tipoUsuarioConverter.convertTipoUsuarioToTipoUsuarioModel(tipoUsuario);
            tiposUsuarioModel.add(tipoUsuarioModel);
        }

        return tiposUsuarioModel;

    }

    @Override
    public TipoUsuario getByTipoId(long tipoid) {

        TipoUsuario tipoUsuario = tipoUsuarioJpaRepository.findByTipoid(tipoid);

        return tipoUsuario;
    }

    @Override
    public List<TipoUsuarioModel> getTiposAdministradores() {

        List<TipoUsuarioModel> tiposUsuarioModel = null;
        List<TipoUsuario> tiposUsuario = tipoUsuarioJpaRepository.findTipoUsuarioByTipoidIsNotLikeOrderByDescripcion(4);

        tiposUsuarioModel = convertTipoUsuarioToTipoUsuarioModel(tiposUsuario);

        return tiposUsuarioModel;
    }

    @Override
    public List<TipoUsuarioModel> getAllTiposUsuario() {

        List<TipoUsuarioModel> tiposUsuarioModel = null;
        List<TipoUsuario> tiposUsuario = tipoUsuarioJpaRepository.findAllByOrderByDescripcion();

        tiposUsuarioModel = convertTipoUsuarioToTipoUsuarioModel(tiposUsuario);

        return tiposUsuarioModel;
    }
}
