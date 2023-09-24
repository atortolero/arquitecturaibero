package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.Prerrequisitos;
import mx.com.gtsf.arquitecturaibero.model.PrerrequisitosModel;

public interface PrerrequisitosService {

    public abstract Prerrequisitos getPrerrequisitoById(long prerrequisitoid);

    public abstract Prerrequisitos addPrerrequisito(PrerrequisitosModel model);
    public abstract int removePrerrequisito(long id);
}
