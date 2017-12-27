package sample.model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;

/**
 * Created by m80028770 on 5/6/2017.
 */
public class ExcelWriter {

    public void writeCMDBDevices(ArrayList<CMDBDevice> cmdbDeviceArrayList,File file) {
        System.out.println("ExcelWriter.writeCMDBDevices");

        try {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Device");

            int rowNum = 0;
            //Title Row
            XSSFCellStyle style1 = (XSSFCellStyle) wb.createCellStyle();
            style1.setFillForegroundColor(new XSSFColor(new java.awt.Color(204, 255, 255)));
            style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
            Font font = wb.createFont();
            font.setBold(true);
            style1.setFont(font);

            int cellNum = 0;
            Row row = sheet.createRow(rowNum++);
            row.setHeightInPoints(25);
            row.createCell(cellNum++).setCellValue("EMS Device ID*");
            row.createCell(cellNum++).setCellValue("Device Name*");
            row.createCell(cellNum++).setCellValue("Device Name in EMS*");
            row.createCell(cellNum++).setCellValue("Device IP");
            row.createCell(cellNum++).setCellValue("EMS*");
            row.createCell(cellNum++).setCellValue("Vendor Label");
            row.createCell(cellNum++).setCellValue("NE Type Label*");
            row.createCell(cellNum++).setCellValue("Parent Device Name");
            row.createCell(cellNum++).setCellValue("Site Name");
            row.createCell(cellNum++).setCellValue("Device State Label");
            row.createCell(cellNum++).setCellValue("Region");
            row.createCell(cellNum++).setCellValue("Version");
            row.createCell(cellNum++).setCellValue("Device Level Label");
            row.createCell(cellNum++).setCellValue("Maintainer");
            row.createCell(cellNum++).setCellValue("Owner");
            row.createCell(cellNum++).setCellValue("Come From");
            row.createCell(cellNum++).setCellValue("Is Hub");
            row.createCell(cellNum++).setCellValue("Is Vip");
            row.createCell(cellNum++).setCellValue("Site State");
            row.createCell(cellNum++).setCellValue("Cabinet Type");
            row.createCell(cellNum++).setCellValue("Integration Date");
            row.createCell(cellNum++).setCellValue("License Expired Date");
            row.createCell(cellNum++).setCellValue("Acceptance Date");
            row.createCell(cellNum++).setCellValue("Rack Type");
            row.createCell(cellNum++).setCellValue("Business Case");
            row.createCell(cellNum++).setCellValue("Asset Number");
            row.createCell(cellNum++).setCellValue("Brand");
            row.createCell(cellNum++).setCellValue("Device Position");
            row.createCell(cellNum++).setCellValue("Capacity");
            row.createCell(cellNum++).setCellValue("Old ID");
            row.createCell(cellNum++).setCellValue("IGWB Software");
            row.createCell(cellNum++).setCellValue("Hardware Lifecycle");
            row.createCell(cellNum++).setCellValue("Ethernet Switch");
            row.createCell(cellNum++).setCellValue("Functional Location");
            row.createCell(cellNum++).setCellValue("Gn Throughput License");
            row.createCell(cellNum++).setCellValue("Payload License");
            row.createCell(cellNum++).setCellValue("Pool");
            row.createCell(cellNum++).setCellValue("Project Definition");
            row.createCell(cellNum++).setCellValue("Remarks Dismantle");
            row.createCell(cellNum++).setCellValue("SAU License");
            row.createCell(cellNum++).setCellValue("Serial Number");
            row.createCell(cellNum++).setCellValue("Software Version");
            row.createCell(cellNum++).setCellValue("VLR capacity");
            row.createCell(cellNum++).setCellValue("Simultaneous PDP");
            row.createCell(cellNum++).setCellValue("Radius (km)");
            row.createCell(cellNum++).setCellValue("Device ID*");
            row.createCell(cellNum++).setCellValue("Description");

            for(Cell cell:row) {
                cell.setCellStyle(style1);
            }


            //Data
            for(CMDBDevice cmdbDevice:cmdbDeviceArrayList) {
                cellNum = 0;
                row = sheet.createRow(rowNum++);
                row.createCell(cellNum++).setCellValue(cmdbDevice.getEms_device_id());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getDevice_name());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getDevice_name_in_ems());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getDevice_ip());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getEms());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getVendor_label());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getNe_type_label());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getParent_device_name());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getSite_name());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getDevice_state_label());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getRegion());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getVersion());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getDevice_level_label());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getMaintainer());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getOwner());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getCome_from());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getIs_hub());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getIs_vip());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getSite_state());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getCabinet_type());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getIntegration_date());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getLicense_expired_date());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getAcceptance_date());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getRack_type());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getBusiness_case());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getAsset_number());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getBrand());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getDevice_position());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getCapacity());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getOld_id());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getIgwb_software());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getHardware_lifecycle());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getEthernet_switch());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getFunctional_location());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getGn_throughput_license());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getPayload_license());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getPool());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getProject_definition());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getRemarks_dismantle());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getSau_license());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getSerial_number());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getSoftware_version());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getVlr_capacity());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getSimultaneous_pdp());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getRadius());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getDevice_id());
                row.createCell(cellNum++).setCellValue(cmdbDevice.getDescription());



            }

            for(int i=0;i<cellNum;i++) {
                sheet.autoSizeColumn(i);
            }




            //write
            FileOutputStream fileOut = null;

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String formatDateTime = now.format(formatter);

            fileOut = new FileOutputStream(file + "\\cmdb_devices_" + formatDateTime+ ".xlsx");
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeCMDBSites(ArrayList<CMDBSite> cmdbSiteArrayList,File file) {
        System.out.println("ExcelWriter.writeCMDBSites");

        try {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Site");

            int rowNum = 0;


            //Title Row

            XSSFCellStyle style1 = (XSSFCellStyle) wb.createCellStyle();
            style1.setFillForegroundColor(new XSSFColor(new java.awt.Color(204, 255, 255)));
            style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
            Font font = wb.createFont();
            font.setBold(true);
            style1.setFont(font);

            int cellNum = 0;
            Row row = sheet.createRow(rowNum++);
            row.setHeightInPoints(25);
            row.createCell(cellNum++).setCellValue("Site ID*");
            row.createCell(cellNum++).setCellValue("Site Name*");
            row.createCell(cellNum++).setCellValue("Region(Site)*");
            row.createCell(cellNum++).setCellValue("FM Office*");
            row.createCell(cellNum++).setCellValue("Longitude");
            row.createCell(cellNum++).setCellValue("Latitude");
            row.createCell(cellNum++).setCellValue("Site Stage Label");
            row.createCell(cellNum++).setCellValue("Site Type Label");
            row.createCell(cellNum++).setCellValue("Parent Site Name");
            row.createCell(cellNum++).setCellValue("Site Priority Label");
            row.createCell(cellNum++).setCellValue("Access Type Label");
            row.createCell(cellNum++).setCellValue("Area");
            row.createCell(cellNum++).setCellValue("Transport Type Label");
            row.createCell(cellNum++).setCellValue("Morphology");
            row.createCell(cellNum++).setCellValue("Contractor");
            row.createCell(cellNum++).setCellValue("Power Type");
            row.createCell(cellNum++).setCellValue("Project Name");
            row.createCell(cellNum++).setCellValue("Location ID");
            row.createCell(cellNum++).setCellValue("Lessor Name");
            row.createCell(cellNum++).setCellValue("Lessor Phone");
            row.createCell(cellNum++).setCellValue("Lessor Address");
            row.createCell(cellNum++).setCellValue("Altitude (m)");
            row.createCell(cellNum++).setCellValue("Is Hub");
            row.createCell(cellNum++).setCellValue("Is VIP");
            row.createCell(cellNum++).setCellValue("Site State");
            row.createCell(cellNum++).setCellValue("Is Boundary");
            row.createCell(cellNum++).setCellValue("Has Room");
            row.createCell(cellNum++).setCellValue("Has Generator");
            row.createCell(cellNum++).setCellValue("Generator Type Label");
            row.createCell(cellNum++).setCellValue("Generator Number");
            row.createCell(cellNum++).setCellValue("Functional Location");
            row.createCell(cellNum++).setCellValue("Integration Date");
            row.createCell(cellNum++).setCellValue("Acceptance Date");
            row.createCell(cellNum++).setCellValue("PLN ID");
            row.createCell(cellNum++).setCellValue("Fuel Tank N.O.");
            row.createCell(cellNum++).setCellValue("Genset Number");
            row.createCell(cellNum++).setCellValue("Air Conditioner N.O.");
            row.createCell(cellNum++).setCellValue("Life Cycle");
            row.createCell(cellNum++).setCellValue("Cluster ID");
            row.createCell(cellNum++).setCellValue("Collocation Id");
            row.createCell(cellNum++).setCellValue("Collocation Name");
            row.createCell(cellNum++).setCellValue("Radius (km)");
            row.createCell(cellNum++).setCellValue("Site Maintainer");
            row.createCell(cellNum++).setCellValue("Owner");
            row.createCell(cellNum++).setCellValue("Site Address");
            row.createCell(cellNum++).setCellValue("Covered Scope");
            row.createCell(cellNum++).setCellValue("Phase");
            row.createCell(cellNum++).setCellValue("Device Location");
            row.createCell(cellNum++).setCellValue("Description");


            for(Cell cell:row) {
                cell.setCellStyle(style1);
            }





            //Data
            for(CMDBSite cmdbSite:cmdbSiteArrayList) {
                cellNum = 0;
                row = sheet.createRow(rowNum++);
                row.createCell(cellNum++).setCellValue(cmdbSite.getSite_id());
                row.createCell(cellNum++).setCellValue(cmdbSite.getSite_name());
                row.createCell(cellNum++).setCellValue(cmdbSite.getRegion());
                row.createCell(cellNum++).setCellValue(cmdbSite.getFm_office());
            }

            for(int i=0;i<cellNum;i++) {
                sheet.autoSizeColumn(i);
            }

            //write
            FileOutputStream fileOut = null;

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String formatDateTime = now.format(formatter);

            fileOut = new FileOutputStream(file + "\\cmdb_sites_" + formatDateTime+ ".xlsx");
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
