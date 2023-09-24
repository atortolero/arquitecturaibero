package mx.com.gtsf.arquitecturaibero.component;

import mx.com.gtsf.arquitecturaibero.entity.Sesion;
import mx.com.gtsf.arquitecturaibero.model.SesionModel;
import org.springframework.stereotype.Component;

@Component("sesionConverter")
public class SesionConverter {

    public Sesion convertSesionModelToSesion(SesionModel model){

        Sesion sesion = new Sesion();

        sesion.setSesionid(model.getSesionid());
        sesion.setToken(model.getToken());
        sesion.setIp(model.getIp());
        sesion.setFechainicio(model.getFechainicio());
        sesion.setFechaactividad(model.getFechaactividad());
        sesion.setUsuario(model.getUsuario());

        return sesion;
    }

    public SesionModel convertSesionToSesionModel(Sesion sesion){

        SesionModel model = new SesionModel();

        model.setSesionid(sesion.getSesionid());
        model.setToken(sesion.getToken());
        model.setIp(sesion.getIp());
        model.setFechainicio(sesion.getFechainicio());
        model.setFechaactividad(sesion.getFechaactividad());
        model.setUsuario(sesion.getUsuario());

        return model;
    }
}

