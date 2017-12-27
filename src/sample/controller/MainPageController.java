/**
 * Sample Skeleton for 'main_page.fxml' Controller Class
 */

package sample.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.model.CMDBAllInOne;
import sample.model.CMDBRule;
import sample.model.Model;

public class MainPageController implements ActionListener{

    Model model;


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tbl_allInOne"
    private TableView<CMDBAllInOne> tbl_allInOne; // Value injected by FXMLLoader

    @FXML // fx:id="col_ems"
    private TableColumn<CMDBAllInOne, String> col_ems; // Value injected by FXMLLoader

    @FXML // fx:id="col_neType"
    private TableColumn<CMDBAllInOne, String> col_neType; // Value injected by FXMLLoader

    @FXML // fx:id="col_deviceName"
    private TableColumn<CMDBAllInOne, String> col_deviceName; // Value injected by FXMLLoader

    @FXML // fx:id="col_siteName"
    private TableColumn<CMDBAllInOne, String> col_siteName; // Value injected by FXMLLoader

    @FXML // fx:id="col_region"
    private TableColumn<CMDBAllInOne, String> col_region; // Value injected by FXMLLoader

    @FXML // fx:id="col_office"
    private TableColumn<CMDBAllInOne, String> col_office; // Value injected by FXMLLoader


    @FXML // fx:id="fileImport_pane"
    private AnchorPane fileImport_pane; // Value injected by FXMLLoader

    @FXML // fx:id="cb_ems"
    private ComboBox<String> cb_ems; // Value injected by FXMLLoader

    @FXML // fx:id="tf_topFile"
    private TextField tf_topFile; // Value injected by FXMLLoader

    @FXML // fx:id="browseBtn"
    private Button browseBtn; // Value injected by FXMLLoader

    @FXML // fx:id="importBtn"
    private Button importBtn; // Value injected by FXMLLoader

    @FXML
    private AnchorPane allInOne_pane;

    @FXML // fx:id="import_progress"
    private ProgressIndicator import_progress; // Value injected by FXMLLoader

    @FXML // fx:id="exportBtn"
    private Button exportBtn; // Value injected by FXMLLoader

    @FXML // fx:id="export_progress"
    private ProgressIndicator export_progress; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tbl_allInOne != null : "fx:id=\"tbl_allInOne\" was not injected: check your FXML file 'main_page.fxml'.";
        assert col_ems != null : "fx:id=\"col_ems\" was not injected: check your FXML file 'main_page.fxml'.";
        assert col_neType != null : "fx:id=\"col_neType\" was not injected: check your FXML file 'main_page.fxml'.";
        assert col_deviceName != null : "fx:id=\"col_deviceName\" was not injected: check your FXML file 'main_page.fxml'.";
        assert col_siteName != null : "fx:id=\"col_siteName\" was not injected: check your FXML file 'main_page.fxml'.";
        assert col_region != null : "fx:id=\"col_region\" was not injected: check your FXML file 'main_page.fxml'.";
        assert col_office != null : "fx:id=\"col_office\" was not injected: check your FXML file 'main_page.fxml'.";

        model = new Model();
        model.addActionListener(this);
        initEmsComboBox();
      //  initAllInOneTable();


    }



    private void initAllInOneTable() {

        ObservableList<CMDBAllInOne> allInOnes = FXCollections.observableArrayList(model.getAllInOnes());

        col_ems.setCellValueFactory(new PropertyValueFactory<CMDBAllInOne,String>("ems"));
        col_deviceName.setCellValueFactory(new PropertyValueFactory<CMDBAllInOne,String>("deviceName"));
        col_neType.setCellValueFactory(new PropertyValueFactory<CMDBAllInOne,String>("neType"));
        col_office.setCellValueFactory(new PropertyValueFactory<CMDBAllInOne,String>("office"));
        col_region.setCellValueFactory(new PropertyValueFactory<CMDBAllInOne,String>("region"));
        col_siteName.setCellValueFactory(new PropertyValueFactory<CMDBAllInOne,String>("siteName"));




        tbl_allInOne.setItems(allInOnes);

        tbl_allInOne.setRowFactory(tv -> new TableRow<CMDBAllInOne>() {
            @Override
            protected void updateItem(CMDBAllInOne item, boolean empty) {
                super.updateItem(item, empty);
                if(item == null) {
                    setStyle("");
                } else if (item.getSiteName() == null || item.getSiteName().equals("")) {
                    setStyle("-fx-background-color: tomato;");
                }else {
                    setStyle("");
                }
            }
        });

    }

    private void initEmsComboBox() {
        ArrayList<String> emsList = new ArrayList<>();
        emsList.add("Wireless_U2000");
        cb_ems.setItems(FXCollections.observableArrayList(emsList));
    }


    private boolean validateTopoForm() {

        boolean result=true;

        if(cb_ems.getValue() == null) {
            cb_ems.setStyle(" -fx-border-color: red;");
            result=false;
        } else {
            cb_ems.setStyle("");
        }

        if(tf_topFile.getText() == null || tf_topFile.getText().equals("")) {
            tf_topFile.setStyle(" -fx-border-color: red;");
            browseBtn.setStyle(" -fx-border-color: red;-fx-border-width: 1px 1px 1px .5px");
            result=false;
        }else {
            tf_topFile.setStyle("");
            browseBtn.setStyle("");

        }
        return result;
    }

    @FXML
    public void browseTopoFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Topo File");
       // fileChooser.setInitialDirectory( new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );
        File file = fileChooser.showOpenDialog(cb_ems.getScene().getWindow());
        if(file != null) {
            System.out.println("MainPageController.exportTT, file: " + file);
            tf_topFile.setText(file.toString());
        }
    }

    @FXML
    public void importTopoFile() {
        System.out.println("MainPageController.importTopoFile");

        if(!validateTopoForm()) {
            return;
        }

        import_progress.setVisible(true);
        importBtn.setDisable(true);
        cb_ems.setDisable(true);
        tf_topFile.setDisable(true);
        browseBtn.setDisable(true);

        String ems = cb_ems.getValue();
        String fileLocation = tf_topFile.getText();
        model.readTopoDevices(ems,fileLocation);


    }




    @FXML
    public void exportDevicesSites() {
        System.out.println("MainPageController.exportDevicesSites");

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select save directory");


        File file = directoryChooser.showDialog(cb_ems.getScene().getWindow());
        if(file != null) {
            System.out.println("MainPageController.exportDevicesSites, file: " + file);

            export_progress.setVisible(true);
            exportBtn.setDisable(true);

            model.exportCMDBDevicesSites(file);
            //model.exportCMDBDevices(file);
            //model.exportCMDBSites(file);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("MainPageController.actionPerformed");
        if(e.getID()==1) {
            // Read Topo File Succeed
            initAllInOneTable();
            fileImport_pane.setVisible(false);
            allInOne_pane.setVisible(true);
            ((Stage) allInOne_pane.getScene().getWindow()).setResizable(true);
        }else if(e.getID()==2) {
            // Export Succeed
            exportBtn.setDisable(false);
            export_progress.setVisible(false);
        }else if (e.getID()==-1){
            import_progress.setVisible(false);
            importBtn.setDisable(false);
            cb_ems.setDisable(false);
            tf_topFile.setDisable(false);
            browseBtn.setDisable(false);
        }
    }

    @FXML
    public void tbl_allInOne_doSearch() {

    }

}
