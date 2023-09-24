package mx.com.gtsf.arquitecturaibero.model;

public class PlanesModel {

    private long planid;
    private String plan;
    private int anioInicio;
    private int periodoInicioid; // 1 Primavera, 2 Verano, 3 Otoño

    public PlanesModel() {
    }

    public PlanesModel(long planid, String plan, int anioInicio, int periodoInicioid) {
        this.planid = planid;
        this.plan = plan;
        this.anioInicio = anioInicio;
        this.periodoInicioid = periodoInicioid;
    }

    public long getPlanid() {
        return planid;
    }

    public void setPlanid(long planid) {
        this.planid = planid;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
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

    @Override
    public String toString() {
        return "PlanesModel{" +
                "planid=" + planid +
                ", plan='" + plan + '\'' +
                ", anioInicio=" + anioInicio +
                ", periodoInicioid=" + periodoInicioid +
                '}';
    }
}
