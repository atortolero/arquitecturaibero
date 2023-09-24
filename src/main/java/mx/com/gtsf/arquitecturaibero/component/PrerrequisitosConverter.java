package mx.com.gtsf.arquitecturaibero.component;

import mx.com.gtsf.arquitecturaibero.entity.Prerrequisitos;
import mx.com.gtsf.arquitecturaibero.model.PrerrequisitosModel;
import org.springframework.stereotype.Component;

@Component("prerrequisitosConverter")
public class PrerrequisitosConverter {

    public Prerrequisitos convertPrerrequisitosModelToPrerrequisitos(PrerrequisitosModel model){

        Prerrequisitos prerrequisito = new Prerrequisitos();

        prerrequisito.setMateriaid(model.getMateriaid());

        return prerrequisito;
    }
}
