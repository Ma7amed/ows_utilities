package sample.model;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.model.CMDBRule;
import sample.model.TopoDevice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by m80028770 on 5/4/2017.
 */
public class ExcelReader {

    public ArrayList<CMDBRule> readCMDBRulesFile() {

        ArrayList<CMDBRule> cmdbRules = new ArrayList<CMDBRule>();
        DataFormatter formatter = new DataFormatter();

        try {
           // Workbook wb = WorkbookFactory.create(new FileInputStream("src/sample/sample.resources/cmdbRules.xlsx"));
            FileInputStream myInputStream = new FileInputStream("src/sample/sample.resources/cmdbRules.xlsx");
            OPCPackage pkg = OPCPackage.open(myInputStream);
            XSSFWorkbook wb = new XSSFWorkbook(pkg);

            Sheet sheet = wb.getSheetAt(0);
           // Row row = sheet.getRow(1);
            //System.out.println("ExcelReader.main: " + row);
            //Cell cell = row.getCell(0);
            //System.out.println("ExcelReader.main: " + formatter.formatCellValue(cell));

            int rowNum = 1;

            while(sheet.getRow(rowNum) !=null) {
                Row row = sheet.getRow(rowNum++);
                String ruleID = formatter.formatCellValue(row.getCell(0));
                String in_ems = formatter.formatCellValue(row.getCell(1));
                String in_neType = formatter.formatCellValue(row.getCell(2));
                String in_deviceName = formatter.formatCellValue(row.getCell(3));
                String out_siteName = formatter.formatCellValue(row.getCell(4));
                String out_region = formatter.formatCellValue(row.getCell(5));
                String out_office = formatter.formatCellValue(row.getCell(6));

                CMDBRule cmdbRule = new CMDBRule(ruleID,in_ems,in_neType,in_deviceName,out_siteName,out_region,out_office);
                cmdbRules.add(cmdbRule);
                //System.out.println("ExcelReader.main: " + cmdbRule);
            }

            pkg.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return cmdbRules;


    }

    public ArrayList<TopoDevice> readTopoDevicesFile(String fileLocation) {

        fileLocation="D:\\Work\\OSS\\Temp_Delete\\20170504\t1.csv";



        return new ArrayList<TopoDevice>();
    }


}
