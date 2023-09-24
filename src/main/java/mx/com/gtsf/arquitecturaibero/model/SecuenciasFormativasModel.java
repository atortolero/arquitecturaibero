package mx.com.gtsf.arquitecturaibero.model;

import java.util.List;

public class SecuenciasFormativasModel {

    private long secuenciaid;
    private String secuencia;
    private long materiasObligatorias;
    private long materiasOptativas;
    List<OpcionesModel> opciones;

    public SecuenciasFormativasModel() {
    }

    public SecuenciasFormativasModel(long secuenciaid, String secuencia, long materiasObligatorias, long materiasOptativas, List<OpcionesModel> opciones) {
        this.secuenciaid = secuenciaid;
        this.secuencia = secuencia;
        this.materiasObligatorias = materiasObligatorias;
        this.materiasOptativas = materiasOptativas;
        this.opciones = opciones;
    }

    public long getSecuenciaid() {
        return secuenciaid;
    }

    public void setSecuenciaid(long secuenciaid) {
        this.secuenciaid = secuenciaid;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public long getMateriasObligatorias() {
        return materiasObligatorias;
    }

    public void setMateriasObligatorias(long materiasObligatorias) {
        this.materiasObligatorias = materiasObligatorias;
    }

    public long getMateriasOptativas() {
        return materiasOptativas;
    }

    public void setMateriasOptativas(long materiasOptativas) {
        this.materiasOptativas = materiasOptativas;
    }

    public List<OpcionesModel> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionesModel> opciones) {
        this.opciones = opciones;
    }

    @Override
    public String toString() {
        return "SecuenciasFormativasModel{" +
                "secuenciaid=" + secuenciaid +
                ", secuencia='" + secuencia + '\'' +
                ", materiasObligatorias=" + materiasObligatorias +
                ", materiasOptativas=" + materiasOptativas +
                ", opciones=" + opciones +
                '}';
    }
}
