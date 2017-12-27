package sample;

import sample.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by m80028770 on 5/4/2017.
 */
public class Launcher implements ActionListener{

    Model model;

    public Launcher() {
        String fileLocation="D:\\Work\\OSS\\Temp_Delete\\20170504\\t1.csv";
        String ems="Wireless_U2000";

        File directoryLocation = new File("D:\\Work\\OSS\\Temp_Delete\\20170506");

        model = new Model();
        model.addActionListener(this);
        model.readTopoDevices(ems,fileLocation);

        //model.exportCMDBDevices(directoryLocation);
    }

    public static void main(String[] args) {
        Launcher launcher = new Launcher();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Launcher.actionPerformed");
    }
}
