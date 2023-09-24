package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.Carreras;

public interface CarrerasService {

    public abstract Carreras getCarreraByid(long id);
    public abstract Carreras getCarreraByName(String carrera);
}
