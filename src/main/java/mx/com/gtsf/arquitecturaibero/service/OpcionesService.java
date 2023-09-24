package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.Opciones;

import java.util.List;

public interface OpcionesService {

    public abstract List<Opciones> getOpcionesBySecuenciaid(long secuenciaid);
    public abstract Opciones getOpcionById(long opcionid);

    public abstract Opciones saveOpcion(Opciones opcion);
}
