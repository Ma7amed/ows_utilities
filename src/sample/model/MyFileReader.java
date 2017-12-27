package sample.model;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by m80028770 on 5/6/2017.
 */
public class MyFileReader {


    public ArrayList<CMDBRule> readCMDBRulesFile() {
        ArrayList<CMDBRule> cmdbRules = new ArrayList<>();

        try {
            //FileReader fileReader = new FileReader(new File("src/sample/resources/cmdbRules.txt"));
            InputStream in = getClass().getResourceAsStream("/sample/resources/cmdbRules.txt");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            String line = null;

            while ((line =bufferedReader.readLine()) !=null) {
                String[] itemList = line.split("\t");
                if(itemList.length!=7) {
                    System.out.println("MyFileReader.readCMDBRulesFile ... " + itemList.length);
                    System.out.println("TxtReader.readCMDBRulesFile .. rule line error: " + line);
                }

                if(itemList[0].equals("ruleID")) {
                    continue;
                }

                CMDBRule cmdbRule = new CMDBRule(itemList[0],itemList[1],itemList[2],itemList[3],itemList[4],itemList[5],itemList[6]);
                cmdbRules.add(cmdbRule);
                System.out.println("MyFileReader.readCMDBRulesFile ... " + cmdbRule);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return cmdbRules;

    }

    public ArrayList<TopoDevice> readTopoDevicesFile(String ems,String fileLocation) {
        System.out.println("MyFileReader.readTopoDevicesFile");

        ArrayList<TopoDevice> topoDevices = new ArrayList<>();


        /*
        try {
            FileReader fileReader = new FileReader(new File(fileLocation));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            int lineNumber=1;
            while ((line =bufferedReader.readLine()) !=null) {

                if(lineNumber++<=9) {
                    continue;
                }

                String[] currentLine = line.split(",");

                if (currentLine.length != 7) {
                    System.out.println("MyFileReader.readCMDBRulesFile ... " + currentLine.length);
                    System.out.println("TxtReader.readCMDBRulesFile .. rule line error: " + line);
                }

                String label = currentLine[3];
                String type = currentLine[6];

                //ignore RRU & Root & Common subnet
                if(type.equals("RRU") || type.equals("Root") || type.equals("Common subnet")) {
                    continue;
                }


                TopoDevice topoDevice = new TopoDevice(ems,label,type);
                System.out.println("MyFileReader.readTopoDevicesFile: " + topoDevice);
                topoDevices.add(topoDevice);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        */
        CSVReader reader = null;
        try {
            System.out.println("MyFileReader.readTopoDevicesFile  ... try");
            reader = new CSVReader(new FileReader(fileLocation));
            System.out.println("MyFileReader.readTopoDevicesFile ... " + reader );
            System.out.println("MyFileReader.readTopoDevicesFile");
            String [] nextLine;
            int lineNumber=1;
            System.out.println("MyFileReader.readTopoDevicesFile ... " + lineNumber);
            System.out.println("MyFileReader.readTopoDevicesFile: " +reader.readNext());
            while ((nextLine = reader.readNext()) != null) {
                System.out.println("MyFileReader.readTopoDevicesFile ... " + lineNumber);
               // System.out.println("TestDrive.main ... reading line :" + lineNumber);
                //ignore first 9 lines
                if(lineNumber++<=9) {
                    continue;
                }
                //stop at the end of the file
                if(nextLine[0].equals("")) {
                    break;
                }

                String label = nextLine[3];
                String type = nextLine[6];

                //ignore RRU & Root & Common subnet
                if(type.equals("RRU") || type.equals("Root") || type.equals("Common subnet")) {
                    continue;
                }
                TopoDevice topoDevice = new TopoDevice(ems,label,type);
               System.out.println("MyFileReader.readTopoDevicesFile: " + topoDevice);
                topoDevices.add(topoDevice);


            }
            System.out.println("MyFileReader.readTopoDevicesFile ... " + "read " + topoDevices.size() + " devices");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }



        return topoDevices;
    }
}
