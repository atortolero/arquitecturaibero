package mx.com.gtsf.arquitecturaibero.component;

import mx.com.gtsf.arquitecturaibero.entity.Opciones;
import mx.com.gtsf.arquitecturaibero.model.OpcionesModel;
import org.springframework.stereotype.Component;

@Component("opcionesConverter")
public class OpcionesConverter {

    public OpcionesModel convertOpcionesToOpcionesModel(Opciones opcion){
        OpcionesModel model = new OpcionesModel();

        model.setOpcionid(opcion.getOpcionid());
        model.setOpcion(opcion.getOpcion());

        return model;
    }

    public Opciones convertOpcionesModelToOpciones(OpcionesModel model){
        Opciones opcion = new Opciones();

        opcion.setOpcionid(model.getOpcionid());
        opcion.setOpcion(model.getOpcion());

        return opcion;
    }
}
