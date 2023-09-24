package mx.com.gtsf.arquitecturaibero.model;

import java.util.List;

public class PlanModel {

    private long planid;
    private String nombrePlan;
    private int anioInicio;
    private int periodoInicioid; // 1 Primavera, 2 Verano, 3 Otoño
    private long numOptativas;
    private long creditos;

    private long creditosOptativas;

    private long creditosObligatorias;
    private String pdf;
    List<SecuenciasFormativasModel> secuenciasFormativas;

    public PlanModel() {
    }

    public PlanModel(long planid, String nombrePlan, int anioInicio, int periodoInicioid, long numOptativas, long creditos, long creditosOptativas, long creditosObligatorias, String pdf, List<SecuenciasFormativasModel> secuenciasFormativas) {
        this.planid = planid;
        this.nombrePlan = nombrePlan;
        this.anioInicio = anioInicio;
        this.periodoInicioid = periodoInicioid;
        this.numOptativas = numOptativas;
        this.creditos = creditos;
        this.creditosOptativas = creditosOptativas;
        this.creditosObligatorias = creditosObligatorias;
        this.pdf = pdf;
        this.secuenciasFormativas = secuenciasFormativas;
    }

    public long getPlanid() {
        return planid;
    }

    public void setPlanid(long planid) {
        this.planid = planid;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }


    public long getNumOptativas() {
        return numOptativas;
    }

    public void setNumOptativas(long numOptativas) {
        this.numOptativas = numOptativas;
    }

    public long getCreditos() {
        return creditos;
    }

    public void setCreditos(long creditos) {
        this.creditos = creditos;
    }

    public long getCreditosOptativas() {
        return creditosOptativas;
    }

    public void setCreditosOptativas(long creditosOptativas) {
        this.creditosOptativas = creditosOptativas;
    }

    public long getCreditosObligatorias() {
        return creditosObligatorias;
    }

    public void setCreditosObligatorias(long creditosObligatorias) {
        this.creditosObligatorias = creditosObligatorias;
    }

    public List<SecuenciasFormativasModel> getSecuenciasFormativas() {
        return secuenciasFormativas;
    }

    public void setSecuenciasFormativas(List<SecuenciasFormativasModel> secuenciasFormativas) {
        this.secuenciasFormativas = secuenciasFormativas;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public int getPeriodoInicioid() {
        return periodoInicioid;
    }

    public void setPeriodoInicioid(int periodoInicioid) {
        this.periodoInicioid = periodoInicioid;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "PlanModel{" +
                "planid=" + planid +
                ", nombrePlan='" + nombrePlan + '\'' +
                ", anioInicio=" + anioInicio +
                ", periodoInicioid=" + periodoInicioid +
                ", numOptativas=" + numOptativas +
                ", creditos=" + creditos +
                ", creditosOptativas=" + creditosOptativas +
                ", creditosObligatorias=" + creditosObligatorias +
                ", pdf='" + pdf + '\'' +
                ", secuenciasFormativas=" + secuenciasFormativas +
                '}';
    }
}
