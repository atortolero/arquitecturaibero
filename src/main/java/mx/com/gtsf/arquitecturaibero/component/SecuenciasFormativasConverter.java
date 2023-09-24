package mx.com.gtsf.arquitecturaibero.component;

import mx.com.gtsf.arquitecturaibero.entity.Opciones;
import mx.com.gtsf.arquitecturaibero.entity.SecuenciaFormativa;
import mx.com.gtsf.arquitecturaibero.model.OpcionesModel;
import mx.com.gtsf.arquitecturaibero.model.SecuenciasFormativasModel;
import mx.com.gtsf.arquitecturaibero.repository.OpcionesJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.OpcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("secuenciasFormativasConverter")
public class SecuenciasFormativasConverter {

    @Autowired
    @Qualifier("opcionesServiceImpl")
    OpcionesService opcionesService;

    @Autowired
    @Qualifier("opcionesConverter")
    OpcionesConverter opcionesConverter;

    public SecuenciasFormativasModel convertSecuenciasFormativasToSecuenciasFormativasModel(SecuenciaFormativa secuenciaFormativa){

        SecuenciasFormativasModel model = new SecuenciasFormativasModel();

        model.setSecuenciaid(secuenciaFormativa.getSecuenciaid());
        model.setSecuencia(secuenciaFormativa.getSecuencia());
        model.setMateriasObligatorias(secuenciaFormativa.getMateriasObligatorias());
        model.setMateriasOptativas(secuenciaFormativa.getMateriasOptativas());

        List<OpcionesModel> opcionesModel = new ArrayList<OpcionesModel>();

        List<Opciones> opciones = opcionesService.getOpcionesBySecuenciaid(secuenciaFormativa.getSecuenciaid());
        if(opciones != null){

            for(Opciones opcion: opciones){
                OpcionesModel modelOpciones = opcionesConverter.convertOpcionesToOpcionesModel(opcion);

                opcionesModel.add(modelOpciones);
            }
        }
        else{
            OpcionesModel modelOpciones = new OpcionesModel();
            opcionesModel.add(modelOpciones);
        }

        model.setOpciones(opcionesModel);

        return model;
    }

    public SecuenciaFormativa convertSecuenciasFormativasModelToSecuenciasFormativas(SecuenciasFormativasModel model){
        SecuenciaFormativa secuenciaFormativa = new SecuenciaFormativa();

        if (model.getSecuenciaid() > 0){
            secuenciaFormativa.setSecuenciaid(model.getSecuenciaid());
        }

        secuenciaFormativa.setSecuencia(model.getSecuencia());
        secuenciaFormativa.setMateriasObligatorias(model.getMateriasObligatorias());
        secuenciaFormativa.setMateriasOptativas(model.getMateriasOptativas());


        return secuenciaFormativa;
    }
}
