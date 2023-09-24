package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.SecuenciaFormativa;
import mx.com.gtsf.arquitecturaibero.model.SecuenciasFormativasModel;

import java.util.List;

public interface SecuenciaFormativaService {

    public abstract List<SecuenciaFormativa> getSecuenciasbyPlanid(long planid);

    public abstract SecuenciaFormativa saveSecuenciaFormativa(SecuenciaFormativa secuenciaFormativa);
    public abstract int removeSecuenciaFormativa(long secuenciaid);

    public int removeSecuenciaFormataivaByPlanid(long planid);

    public abstract SecuenciaFormativa getSecuenciaById(long secuenciaid);
}
