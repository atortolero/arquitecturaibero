package mx.com.gtsf.arquitecturaibero.component;


import mx.com.gtsf.arquitecturaibero.entity.TipoUsuario;
import mx.com.gtsf.arquitecturaibero.model.TipoUsuarioModel;
import org.springframework.stereotype.Component;

@Component("tipoUsuarioConverter")
public class TipoUsuarioConverter {

    public TipoUsuario convertTipoUsuarioModelToTipoUsuario(TipoUsuarioModel model){

        TipoUsuario tipoUsuario = new TipoUsuario();

        tipoUsuario.setTipoid(model.getTipoid());
        tipoUsuario.setDescripcion(model.getDescripcion());

        return tipoUsuario;
    }

    public TipoUsuarioModel convertTipoUsuarioToTipoUsuarioModel(TipoUsuario tipoUsuario){

        TipoUsuarioModel model = new TipoUsuarioModel();

        model.setTipoid(tipoUsuario.getTipoid());
        model.setDescripcion(tipoUsuario.getDescripcion());

        return model;
    }
}

