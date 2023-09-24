package mx.com.gtsf.arquitecturaibero.component;


import mx.com.gtsf.arquitecturaibero.entity.*;
import mx.com.gtsf.arquitecturaibero.model.UsuariosModel;
import mx.com.gtsf.arquitecturaibero.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("usuariosConverter")
public class UsuariosConverter {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(UsuariosConverter.class);

    @Autowired
    @Qualifier("tipoUsuarioServiceImpl")
    TipoUsuarioService tipoUsuarioService;

    @Autowired
    @Qualifier("passwordEncrypt")
    PasswordEncrypt passwordEncrypt;

    @Autowired
    @Qualifier("semestresServiceImpl")
    SemestresService semestresService;

    @Autowired
    @Qualifier("alumnosCarrerasServiceImpl")
    AlumnosCarrerasService alumnosCarrerasService;

    @Autowired
    @Qualifier("carrerasServiceImpl")
    CarrerasService carrerasService;

    public Usuarios convertUsuariosModelToUsuarios(UsuariosModel model){

        Usuarios usuario = new Usuarios();

        usuario.setUsuarioid(model.getUsuarioid());
        usuario.setAdmininterno(model.getAdmininterno());
        usuario.setPassword(model.getPassword());
        usuario.setNombre(model.getNombre());
        usuario.setAppaterno(model.getApPaterno());
        usuario.setApmaterno(model.getApMaterno());
        usuario.setEmail(model.getEmail());
        usuario.setActivo(model.getActivo());

        TipoUsuario tipoUsuario = tipoUsuarioService.getByTipoId(model.getTipoid());
        usuario.setTipoUsuario(tipoUsuario);
        return usuario;
    }


    public UsuariosModel convertUsuariosToUsuariosModel(Usuarios usuario){

        UsuariosModel model = new UsuariosModel();

        model.setUsuarioid(usuario.getUsuarioid());
        model.setAdmininterno(usuario.getAdmininterno());
        model.setPassword(usuario.getPassword());
        model.setNombre(usuario.getNombre());
        model.setApPaterno(usuario.getAppaterno());
        model.setApMaterno(usuario.getApmaterno());
        model.setEmail(usuario.getEmail());
        model.setActivo(usuario.getActivo());
        model.setTipoid(usuario.getTipoUsuario().getTipoid());

        return model;
    }

}

