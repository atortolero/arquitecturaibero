package mx.com.gtsf.arquitecturaibero.model;

public class UserPasswordModel {
    private long usuariosid;
    private String password;

    public UserPasswordModel(long usuariosid, String password) {
        this.usuariosid = usuariosid;
        this.password = password;
    }

    public UserPasswordModel() {
    }

    public long getUsuariosid() {

        return usuariosid;
    }

    public void setUsuariosid(long usuariosid) {

        this.usuariosid = usuariosid;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public String toString() {
        return "UserPasswordModel{" +
                "usuariosid=" + usuariosid +
                ", password='" + password + '\'' +
                '}';
    }
}
