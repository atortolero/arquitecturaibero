package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.component.CurrentDateGenerator;
import mx.com.gtsf.arquitecturaibero.component.PasswordGenerator;
import mx.com.gtsf.arquitecturaibero.component.UsuariosConverter;
import mx.com.gtsf.arquitecturaibero.entity.TipoUsuario;
import mx.com.gtsf.arquitecturaibero.entity.Usuarios;
import mx.com.gtsf.arquitecturaibero.model.UsuariosModel;
import mx.com.gtsf.arquitecturaibero.repository.TipoUsuarioJpaRepository;
import mx.com.gtsf.arquitecturaibero.repository.UsuariosJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.UsuariosService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("usuariosServiceImpl")
public class UsuariosServiceImpl implements UsuariosService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(UsuariosServiceImpl.class);

    @Autowired
    @Qualifier("usuariosJpaRepository")
    UsuariosJpaRepository usuariosJpaRepository;

    @Autowired
    @Qualifier("tipoUsuarioJpaRepository")
    TipoUsuarioJpaRepository tipoUsuarioJpaRepository;


    @Autowired
    @Qualifier("usuariosConverter")
    UsuariosConverter usuariosConverter;

    @Autowired
    @Qualifier("currentDateGenerator")
    CurrentDateGenerator currentDateGenerator;

    @Autowired
    @Qualifier("passwordGenerator")
    PasswordGenerator passwordGenerator;

    @Override
    public List<UsuariosModel> listAllUsersByType(int type) {
        List<Usuarios> usuarios = new ArrayList<Usuarios>();
        List<UsuariosModel> usuariosModel = new ArrayList<UsuariosModel>();

        TipoUsuario tipoUsuario = tipoUsuarioJpaRepository.findByTipoid(type); // Admin: 1, 2 y 3, Normales: 4
        usuarios =  usuariosJpaRepository.findUsuariosByTipoUsuarioOrderByAppaterno(tipoUsuario);

        for(Usuarios usuario: usuarios){
            UsuariosModel usrModel = usuariosConverter.convertUsuariosToUsuariosModel(usuario);
            usuariosModel.add(usrModel);
        }

        return usuariosModel;
    }

    @Override
    public Usuarios getUserById(long id) {
        return usuariosJpaRepository.getById(id);
    }

    @Override
    public Usuarios getUserByEmail(String email) {

        try {
            Usuarios usuario = usuariosJpaRepository.findByEmail(email);
            return usuario;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    @Transactional
    public UsuariosModel addUsuarios(UsuariosModel usrModel) {
        Usuarios usuario = usuariosConverter.convertUsuariosModelToUsuarios(usrModel);

        usuario =  usuariosJpaRepository.save(usuario);

        UsuariosModel model = usuariosConverter.convertUsuariosToUsuariosModel(usuario);

        return model;
    }

    @Override
    @Transactional
    public int removeUsuario(long id) {
        usuariosJpaRepository.deleteUsuario(id);
        return 0;
    }

    @Override
    public UsuariosModel updateUsuario(UsuariosModel usrModel) {

        Usuarios usuario = usuariosConverter.convertUsuariosModelToUsuarios(usrModel);

        usuario =  usuariosJpaRepository.save(usuario);

        UsuariosModel model = usuariosConverter.convertUsuariosToUsuariosModel(usuario);

        return model;
    }
}
