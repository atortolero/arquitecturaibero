package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.SemestreMaterias;
import mx.com.gtsf.arquitecturaibero.model.MateriaPrerrequisitoQuery;
import mx.com.gtsf.arquitecturaibero.model.StatusPrerrequisitoQuery;

import java.util.List;

public interface SemestreMateriasService {

    public abstract List<SemestreMaterias> getSemestreMateriasBySemestreid(long semestreid);
    public abstract MateriaPrerrequisitoQuery getMateriaPrerrequisito(long alumnoid, long materiaid);

    public abstract SemestreMaterias saveSemestreMaterias(SemestreMaterias semestreMaterias);

    public abstract int getStatusPrerrequisito(long alumnoid, long materiaid);
}
