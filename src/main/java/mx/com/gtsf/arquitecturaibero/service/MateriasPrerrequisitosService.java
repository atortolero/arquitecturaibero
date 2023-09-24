package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.MateriasPrerrequisitos;

import java.util.List;

public interface MateriasPrerrequisitosService {

    public abstract List<MateriasPrerrequisitos> getPrerrequisitosByMateriaid(long materiaid);

    public abstract MateriasPrerrequisitos addMateriasPrerrequisitos(MateriasPrerrequisitos materiasPrerrequisitos);
    public abstract int removeMateriasPrerrequisitosByMateriaid(long materiaid);

}
