package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.Usuarios;
import mx.com.gtsf.arquitecturaibero.model.UsuariosModel;


import java.util.List;

public interface UsuariosService {

    public abstract List<UsuariosModel> listAllUsersByType(int type);
    public abstract Usuarios getUserById(long id);
    public abstract Usuarios getUserByEmail(String email);
    public abstract UsuariosModel addUsuarios(UsuariosModel usrModel);
    public abstract int removeUsuario(long id);
    public abstract UsuariosModel updateUsuario(UsuariosModel usrModel);

}
