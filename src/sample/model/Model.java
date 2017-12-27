package sample.model;

import javafx.concurrent.Task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by m80028770 on 5/4/2017.
 */
public class Model {

    ArrayList<ActionListener> listeners;

    ExcelReader excelReader;
    MyFileReader myFileReader;

    ExcelWriter excelWriter;

    ArrayList<CMDBRule> ruleList;
    ArrayList<TopoDevice> topoDevices;
    ArrayList<CMDBAllInOne> allInOnes;
    ArrayList<CMDBDevice> cmdbDevices;
    ArrayList<CMDBSite> cmdbSites;

    public Model() {
        listeners = new ArrayList<>();
        excelReader = new ExcelReader();
        myFileReader = new MyFileReader();
        excelWriter = new ExcelWriter();
        ruleList = new ArrayList<>();
        topoDevices = new ArrayList<>();
        allInOnes = new ArrayList<>();
        cmdbDevices = new ArrayList<>();
        cmdbSites = new ArrayList<>();



        ruleList.addAll(myFileReader.readCMDBRulesFile());
    }



    public void readTopoDevices(String ems, String fileLocation) {
        System.out.println("Model.readTopoDevices");
                Task readTask = new Task() {
            @Override
            protected Object call() throws Exception {
                //Thread.sleep(2000);
                topoDevices.removeAll(topoDevices);
                topoDevices.addAll(myFileReader.readTopoDevicesFile(ems,fileLocation));
                generateAllInOneDevices();
                generateCMDBDevices();
                generateCMDBSite();
                //exportCMDBDevices(new File("D:\\Work\\OSS\\Temp_Delete\\20170506"));
                return null;
            }
        };



        readTask.setOnSucceeded(event -> {
            System.out.println("Model.readTopoDevices");
            for(ActionListener listener:listeners) {
                listener.actionPerformed(new ActionEvent(this,1,"Read Topo File Succeed"));
            }
        });

        readTask.setOnFailed(event -> {
            for(ActionListener listener:listeners) {
                listener.actionPerformed(new ActionEvent(this,-1,"Read Topo File Failed"));
            }
        });

        Thread t1 = new Thread(readTask);
        t1.setDaemon(true);
      t1.start();

    }

    private void generateAllInOneDevices(){

        allInOnes.removeAll(allInOnes);
        for(TopoDevice topoDevice:topoDevices) {
            allInOnes.add(CMDBUtil.CMDBAllInOne(topoDevice,ruleList));
        }
    }

    private void generateCMDBDevices() {
        for(CMDBAllInOne cmdbAllInOne: allInOnes) {
            // Generate CMDBDevice
            CMDBDevice cmdbDevice = new CMDBDevice();
            cmdbDevice.setDevice_id(cmdbAllInOne.getEms() + ":" + cmdbAllInOne.getDeviceName());
            cmdbDevice.setEms_device_id(cmdbAllInOne.getDeviceName());
            cmdbDevice.setDevice_name(cmdbAllInOne.getDeviceName());
            cmdbDevice.setDevice_name_in_ems(cmdbAllInOne.getDeviceName());
            cmdbDevice.setEms(cmdbAllInOne.getEms());
            cmdbDevice.setNe_type_label(cmdbAllInOne.getNeType());
            cmdbDevice.setSite_name(cmdbAllInOne.getSiteName());
            cmdbDevice.setRegion(cmdbAllInOne.getRegion());


            cmdbDevices.add(cmdbDevice);
        }
        System.out.println("Model.generateCMDBDevices ... " + "Successfully generated " + cmdbDevices.size() + " devices");
    }

    private void generateCMDBSite() {

        for(CMDBAllInOne allInOne:allInOnes) {
            CMDBSite cmdbSite = new CMDBSite();
            cmdbSite.setSite_id(allInOne.getSiteName());
            cmdbSite.setSite_name(allInOne.getSiteName());
            cmdbSite.setFm_office(allInOne.getOffice());
            cmdbSite.setRegion(allInOne.getRegion());
            if(!cmdbSites.contains(cmdbSite)) {
                cmdbSites.add(cmdbSite);
            }
        }

        System.out.println("Model.generateCMDBSite ... " + "Successfully generated " + cmdbSites.size() + " sites");


    }

    public ArrayList<CMDBAllInOne> getAllInOnes() {
        return new ArrayList<CMDBAllInOne>(allInOnes);
    }

    public ArrayList<CMDBRule> getRuleList() {
        return ruleList;
    }

    public void addActionListener(ActionListener actionListener) {
        this.listeners.add(actionListener);
    }

    public void exportCMDBDevices(File file) {
        System.out.println("Model.exportCMDBDevices");
        excelWriter.writeCMDBDevices(cmdbDevices,file);
    }

    public void exportCMDBSites(File file) {
        System.out.println("Model.exportCMDBSites");
        excelWriter.writeCMDBSites(cmdbSites,file);
    }


    public void exportCMDBDevicesSites(File file) {
        Task exportTask = new Task() {
            @Override
            protected Object call() throws Exception {

                excelWriter.writeCMDBDevices(cmdbDevices,file);
                excelWriter.writeCMDBSites(cmdbSites,file);
                return null;
            }
        };

        exportTask.setOnSucceeded(event -> {
            System.out.println("Model.exportCMDBDevicesSites");
            for(ActionListener listener:listeners) {
                listener.actionPerformed(new ActionEvent(this,2,"Export Succeed"));
            }
        });

        exportTask.setOnFailed(event -> {
            for(ActionListener listener:listeners) {
                listener.actionPerformed(new ActionEvent(this,-2,"Export Failed"));
            }
        });

        Thread t1 = new Thread(exportTask);
        t1.setDaemon(true);
        t1.start();

    }

}
