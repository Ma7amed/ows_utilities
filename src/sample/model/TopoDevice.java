package sample.model;

/**
 * Created by m80028770 on 5/4/2017.
 */
public class TopoDevice {

    private String ems;
    private String label;
    private String type;

    public TopoDevice(String ems, String label, String type) {
        this.ems = ems;
        this.label = label;
        this.type = type;
    }

    public String getEms() {
        return ems;
    }

    public void setEms(String ems) {
        this.ems = ems;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ems: " + getEms() + ", label: " + getLabel() + ", type: " + getType();
    }
}
