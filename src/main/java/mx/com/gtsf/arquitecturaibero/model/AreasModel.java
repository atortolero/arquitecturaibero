package mx.com.gtsf.arquitecturaibero.model;

public class AreasModel {

    private long areaid;
    private String area;
    private String color;

    public AreasModel() {
    }

    public AreasModel(long areaid, String area, String color) {
        this.areaid = areaid;
        this.area = area;
        this.color = color;
    }

    public long getAreaid() {
        return areaid;
    }

    public void setAreaid(long areaid) {
        this.areaid = areaid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "AreasModel{" +
                "areaid=" + areaid +
                ", area='" + area + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
