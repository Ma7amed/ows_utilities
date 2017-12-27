package sample.model;

/**
 * Created by m80028770 on 5/4/2017.
 */
public class CMDBRule {

    private String ruleID;
    private String in_ems;
    private String in_neType;
    private String in_deviceName;
    private String out_siteName;
    private String out_region;
    private String out_office;

    public static String DEVICENAME="DEVICENAME";


    public CMDBRule(String ruleID, String in_ems, String in_neType, String in_deviceName, String out_siteName, String out_region, String out_office) {
        this.ruleID = ruleID;
        this.in_ems = in_ems;
        this.in_neType = in_neType;
        this.in_deviceName = in_deviceName;
        this.out_siteName = out_siteName;
        this.out_region = out_region;
        this.out_office = out_office;
    }

    public String getRuleID() {
        return ruleID;
    }

    public void setRuleID(String ruleID) {
        this.ruleID = ruleID;
    }

    public String getIn_ems() {
        return in_ems;
    }

    public void setIn_ems(String in_ems) {
        this.in_ems = in_ems;
    }

    public String getIn_neType() {
        return in_neType;
    }

    public void setIn_neType(String in_neType) {
        this.in_neType = in_neType;
    }

    public String getIn_deviceName() {
        return in_deviceName;
    }

    public void setIn_deviceName(String in_deviceName) {
        this.in_deviceName = in_deviceName;
    }

    public String getOut_siteName() {
        return out_siteName;
    }

    public void setOut_siteName(String out_siteName) {
        this.out_siteName = out_siteName;
    }

    public String getOut_region() {
        return out_region;
    }

    public void setOut_region(String out_region) {
        this.out_region = out_region;
    }

    public String getOut_office() {
        return out_office;
    }

    public void setOut_office(String out_office) {
        this.out_office = out_office;
    }



    @Override
    public String toString() {
        return  getRuleID() + ": in_ems: " + getIn_ems() + ", in_neType: " + getIn_neType() +", in_deviceName: " + getIn_deviceName() ;
    }
}
