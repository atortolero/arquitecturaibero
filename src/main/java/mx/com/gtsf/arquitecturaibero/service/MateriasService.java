package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.Materias;
import mx.com.gtsf.arquitecturaibero.model.MateriaModel;
import mx.com.gtsf.arquitecturaibero.model.MateriasModel;

import java.util.List;

public interface MateriasService {

    public abstract List<MateriasModel> getAllMaterias();

    public abstract MateriaModel saveMateria(MateriaModel materia);
    public abstract int removeMateria(long materiaid);

    public abstract MateriaModel getMateriaById(long materiaid);
    public abstract Materias getMateriaEntityById(long materiaid);
    public abstract List<MateriaModel> getMateriasByPlanId(long planid);
    public abstract List<MateriaModel> getMateriasBySecuenciaId(long secuenciaid);
}
