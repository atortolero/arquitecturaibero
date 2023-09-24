package mx.com.gtsf.arquitecturaibero.model;

public class TokenModel {

    public String token;
    public long expiresin;

    public TokenModel(String token, long expiresin) {
        this.token = token;
        this.expiresin = expiresin;
    }

    public TokenModel() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresin() {
        return expiresin;
    }

    public void setExpiresin(long expiresin) {
        this.expiresin = expiresin;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "token='" + token + '\'' +
                ", expiresin=" + expiresin +
                '}';
    }
}

