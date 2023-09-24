package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.TipoUsuario;
import mx.com.gtsf.arquitecturaibero.model.TipoUsuarioModel;

import java.util.List;

public interface TipoUsuarioService {

    public abstract TipoUsuario getByTipoId(long tipoid);
    public abstract List<TipoUsuarioModel> getTiposAdministradores();
    public abstract List<TipoUsuarioModel> getAllTiposUsuario();
}