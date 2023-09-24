package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.Alumnos;
import mx.com.gtsf.arquitecturaibero.model.AlumnosModel;
import mx.com.gtsf.arquitecturaibero.model.AlumnosSemestresModel;

public interface AlumnosService {

    public abstract AlumnosModel getStudentInfo(AlumnosModel alumnosModel);

    public abstract AlumnosModel updateSemestre(AlumnosModel alumnosModel);

    public abstract AlumnosSemestresModel updateFirstSemester(AlumnosSemestresModel alumnosModel);

    public abstract Alumnos getAlumnoById(long alumnoid);

    public abstract Alumnos saveAlumno(Alumnos alumno);
}
