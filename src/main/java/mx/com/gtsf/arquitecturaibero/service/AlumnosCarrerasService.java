package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.AlumnosCarreras;

import java.util.List;

public interface AlumnosCarrerasService {

    public abstract AlumnosCarreras getCarrerasByAlumnoid(long alumnoid);
    public abstract AlumnosCarreras saveAlumnosCarreras(AlumnosCarreras alumnosCarreras);
}
