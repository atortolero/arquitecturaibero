package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.Sesion;

import java.util.List;

public interface SesionService {

    public abstract List<Sesion> listAllSessions();
    public abstract Sesion getSessionByToken(String token);
    public abstract List<Sesion> getSessionByUserId(long usuarioid);
    public abstract Sesion addSession(Sesion session);
    public abstract boolean validSession(String token);
    public abstract int removeSession(String token);
    public abstract int removeSessionByUserId(long userid);
    public abstract Sesion updateSession(Sesion session);
}

