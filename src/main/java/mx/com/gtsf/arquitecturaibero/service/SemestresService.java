package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.Semestres;

import java.util.List;

public interface SemestresService {

    public abstract List<Semestres> getSemestreByAlumnoid(long alumnoid);

    public abstract Semestres findLastSemestreByAlumnoid(long alumnoid);

    public abstract int removeSemestreByAlumnoid(long alumnoid);

    public abstract Semestres saveSemestre(Semestres semestre);
}
