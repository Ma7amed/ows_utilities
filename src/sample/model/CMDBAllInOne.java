package sample.model;


/**
 * Created by m80028770 on 5/4/2017.
 */
public class CMDBAllInOne {

    private String ems;
    private String neType;
    private String deviceName;
    private String siteName;
    private String office;
    private String region;




    public String getEms() {
        return ems;
    }

    public void setEms(String ems) {
        this.ems = ems;
    }

    public String getNeType() {
        return neType;
    }

    public void setNeType(String neType) {
        this.neType = neType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "ems: " + this.ems +
                ", neType: " + this.neType +
                ", deviceName: " + this.deviceName +
                ", siteName: " + siteName +
                ", office: " + office +
                ", region: " + region;

    }
}
