package sample.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by m80028770 on 5/4/2017.
 */
public class CMDBUtil {

    public static CMDBAllInOne CMDBAllInOne(TopoDevice topoDevice, ArrayList<CMDBRule> cmdbRules) {

        CMDBAllInOne cmdbAllInOne = new CMDBAllInOne();
        cmdbAllInOne.setEms(topoDevice.getEms());
        cmdbAllInOne.setNeType(topoDevice.getType());
        cmdbAllInOne.setDeviceName(topoDevice.getLabel());


        // System.out.println("CMDBUtil.CMDBAllInOne .. topodevice: " + topoDevice.toString());

        boolean match = false;
        for (CMDBRule cmdbRule : cmdbRules) {

            // System.out.println("CMDBUtil.CMDBAllInOne .. matching rule: " + cmdbRule.toString());
            // rule will match if in_ems, in_neType, in_device_type

            // match in_ems
            if (!topoDevice.getEms().matches(cmdbRule.getIn_ems())) {
                //    System.out.println("CMDBUtil.CMDBAllInOne .. failed to match ems");
                continue;
            }

            // match in_neType
            if (!topoDevice.getType().matches(cmdbRule.getIn_neType())) {
                //   System.out.println("CMDBUtil.CMDBAllInOne .. failed to match netype");
                continue;
            }

/*
            // match in_device_name
            if (!topoDevice.getLabel().matches("(?i)" + cmdbRule.getIn_deviceName())) {
               // System.out.println("CMDBUtil.CMDBAllInOne .. failed to match device name");
                continue;
            }


            if (!topoDevice.getLabel().matches("(?i)" + cmdbRule.getIn_siteName() )) {
                // didn't match sitename config
               // System.out.println("CMDBUtil.CMDBAllInOne .. " +cmdbRule.getRuleID() + " .. failed to match site");
                continue;
            }

  //          match = true;
          //  System.out.println("CMDBUtil.CMDBAllInOne ... " + "rule: " + cmdbRule.getRuleID() + " matched");

            Pattern out_sitename_pattern = Pattern.compile(cmdbRule.getOut_siteName());
            Matcher out_sitename_matcher = out_sitename_pattern.matcher(topoDevice.getLabel());

            if (out_sitename_matcher.find()) {
                //Set Site Name
                cmdbAllInOne.setSiteName(out_sitename_matcher.group(0));
            } else {
                match = false;
            }
            // Get Region
            cmdbAllInOne.setRegion(cmdbRule.getOut_region());

            // Get Office Name
            cmdbAllInOne.setOffice(cmdbRule.getOut_office());

            break;
        }
        */

            //confirming in device match
            Pattern pattern = Pattern.compile(cmdbRule.getIn_deviceName());
            Matcher matcher = pattern.matcher(topoDevice.getLabel());

            if (!matcher.find() ) {
                continue;
            }

            pattern = Pattern.compile(cmdbRule.getOut_siteName());
            matcher = pattern.matcher(topoDevice.getLabel());

            if (matcher.find()) {
                //Set Site Name
                match = true;
                System.out.println("CMDBUtil.CMDBAllInOne ... " + "rule: " + cmdbRule.getRuleID() + " matched");
                cmdbAllInOne.setSiteName(matcher.group(0));
                cmdbAllInOne.setRegion(cmdbRule.getOut_region());
                cmdbAllInOne.setOffice(cmdbRule.getOut_office());
                break;
            } else {
                match = false;
            }

        }


        if (!match) {
            System.out.println("CMDBUtil.CMDBAllInOne .. " + "no rules match found");
        }

        return cmdbAllInOne;

    }

}





