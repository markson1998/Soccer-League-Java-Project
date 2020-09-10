package application.gui.fxml;

import application.entities.Manager;
import application.entities.Team;
import application.entities.controllers.ManagerController;
import application.entities.controllers.TeamController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ManagerWindowController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private TableView<Manager> manager_table;
    @FXML
    private TableColumn<Manager, String> manager_firstname;
    @FXML
    private TableColumn<Manager, String> manager_middlename;
    @FXML
    private TableColumn<Manager, String> manager_lastname;
    @FXML
    private TableColumn<Manager, String> manager_phone;
    @FXML
    private TableColumn<Manager, String> manager_email;
    @FXML
    private TableColumn<Manager, String> manager_dob;
    @FXML
    private TableColumn<Manager, Integer> manager_rating;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button removeButtton;
    @FXML
    private Button backButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField middleNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField dobField;
    @FXML
    private TextField starRatingField;
    @FXML
    private ComboBox<String> teamToManageMenu;
    
    Manager selectedManager;
    TeamWindowController teamWindowController;
    private ObservableList<Team> teamData;
    TeamController teamController;
    Team t;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firstNameField.setEditable(false);
        middleNameField.setEditable(false);
        lastNameField.setEditable(false);
        phoneField.setEditable(false);
        emailField.setEditable(false);
        manager_dob.setEditable(false);
        starRatingField.setEditable(false);
        teamToManageMenu.setDisable(true);
        teamToManageMenu.setStyle("-fx-opacity: 1");
        displayDataToTableView();
        editButton.setDisable(true);
        removeButtton.setDisable(true);
        
        teamWindowController = new TeamWindowController();
        teamController = new TeamController();
        teamData = teamWindowController.getTeamData();
        
        if(!teamData.isEmpty()){
            ObservableList<String> options = FXCollections.observableArrayList();
            
            for(Team p : teamData){
                options.add(p.getTeamName());
            }
            teamToManageMenu.getItems().addAll(options);
        }
    }   
    
    public void displayDataToTableView(){
        initColumns();
        manager_table.setItems(getManagerData());
    }
    
    @FXML
    public void getSelectedRowData(){
        manager_table.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                if(manager_table.getSelectionModel().getSelectedItem() != null){
                    editButton.setDisable(false);
                    removeButtton.setDisable(false);
                    selectedManager = manager_table.getSelectionModel().getSelectedItem();
                    firstNameField.setText(selectedManager.getFirstName());
                    middleNameField.setText(selectedManager.getMiddleName());
                    lastNameField.setText(selectedManager.getLastName());
                    phoneField.setText(selectedManager.getPhone());
                    emailField.setText(selectedManager.getEmail());
                    dobField.setText(String.valueOf(selectedManager.getDob()));
                    starRatingField.setText(String.valueOf(selectedManager.getStarRating()));
                    try{
                        teamToManageMenu.setValue(selectedManager.getTeamToManage().getTeamName());
                    }
                    catch(Exception e){
                        teamToManageMenu.setValue("Select Team");
                    }
                }
            }
        });
    }

    public void initColumns(){
        manager_firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        manager_middlename.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        manager_lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        manager_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        manager_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        manager_dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        manager_rating.setCellValueFactory(new PropertyValueFactory<>("starRating"));
    }
    
    private ObservableList<Manager> managerData;
    private ManagerController managerController;
    
    public ObservableList<Manager> getManagerData(){
        managerController = new ManagerController();
        managerData = FXCollections.observableArrayList(managerController.getManagerData());
        if(managerData == null){
            return FXCollections.observableArrayList();
        }
        return managerData;
    }
    
    public void resetFields(){
        firstNameField.setText("");
        middleNameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        dobField.setText("");
        starRatingField.setText("");
        teamToManageMenu.setValue("Select Team");
        
        firstNameField.setEditable(false);
        middleNameField.setEditable(false);
        lastNameField.setEditable(false);
        phoneField.setEditable(false);
        emailField.setEditable(false);
        dobField.setEditable(false);
        starRatingField.setEditable(false);
        teamToManageMenu.setDisable(true);
        
        editButton.setDisable(false);
    }

    @FXML
    private void addManagerBtn(ActionEvent event) {
        updateButton.setVisible(false);
        saveButton.setVisible(true);
        firstNameField.setEditable(true);
        middleNameField.setEditable(true);
        lastNameField.setEditable(true);
        phoneField.setEditable(true);
        emailField.setEditable(true);
        dobField.setEditable(true);
        starRatingField.setEditable(true);
        teamToManageMenu.setDisable(false);
        
        firstNameField.setText("");
        middleNameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        dobField.setText("");
        starRatingField.setText("");
        teamToManageMenu.setValue("Select Team");
        
        
        firstNameField.requestFocus();
        editButton.setDisable(true);
        removeButtton.setDisable(true);
    }

    @FXML
    private void editManagerButtonAction(ActionEvent event) {
        saveButton.setVisible(false);
        updateButton.setVisible(true);
        removeButtton.setDisable(true);
        firstNameField.setEditable(true);
        middleNameField.setEditable(true);
        lastNameField.setEditable(true);
        phoneField.setEditable(true);
        emailField.setEditable(true);
        dobField.setEditable(true);
        starRatingField.setEditable(true);
        teamToManageMenu.setDisable(false);
        firstNameField.requestFocus();
    }

    @FXML
    private void removeManagerData(ActionEvent event) {
       if(managerController.removeManagerData(selectedManager.getManager_id())){
            System.out.println(selectedManager.toString());
            System.out.println("Data Deleted from db");
            DialogBox.infoDialogBox("Success", "Record Has be deleted Successfully..");
            removeButtton.setDisable(true);
            resetFields();
            displayDataToTableView();
            editButton.setDisable(true);
        }
        else{
            System.out.println("Record is not Deleted...");
            DialogBox.errorDialogBox("Record is not Deleted...");
        }
    }

    @FXML
    private void backButtonAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/application/gui/fxml/MainWindow.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/application/gui/style/Styles.css").toExternalForm());
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Soccer League");
            stage.setScene(scene);
            stage.show();
        
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateManagerData(ActionEvent event) {
        selectedManager.setFirstName(firstNameField.getText().toString());
        selectedManager.setMiddleName(middleNameField.getText().toString());
        selectedManager.setLastName(lastNameField.getText().toString());
        selectedManager.setPhone(phoneField.getText().toString());
        selectedManager.setEmail(emailField.getText().toString());
        selectedManager.setDob(dobField.getText().toString());
        selectedManager.setStarRating(Integer.parseInt(starRatingField.getText().toString()));
        selectedManager.setTeamToManage(getTeamForManaging());
        
        if(managerController.updateManagerData(selectedManager, selectedManager.getManager_id())){
            System.out.println(selectedManager.toString());
            System.out.println("Data updated into db");
            updateButton.setVisible(false);
            resetFields();
            DialogBox.infoDialogBox("Success", "Record Has Been Updated Successfully...");
            displayDataToTableView();
            editButton.setDisable(true);
            removeButtton.setDisable(true);
        }
        else{
            System.out.println("Data is not updated");
            DialogBox.errorDialogBox("Record is not Updated...");
        }
    }

    @FXML
    private void saveManagerData(ActionEvent event) {
        Manager manager = new Manager();
        
        manager.setFirstName(firstNameField.getText().toString());
        manager.setMiddleName(middleNameField.getText().toString());
        manager.setLastName(lastNameField.getText().toString());
        manager.setPhone(phoneField.getText().toString());
        manager.setEmail(emailField.getText().toString());
        manager.setDob(dobField.getText().toString());
        manager.setStarRating(Integer.parseInt(starRatingField.getText().toString()));
        manager.setTeamToManage(getTeamForManaging());
        
        if(managerController.insertManagerData(manager)){
            System.out.println("Data inserted into db");
            saveButton.setVisible(false);
            resetFields();
            System.out.println(manager.toString());
            displayDataToTableView();
            editButton.setDisable(true);
        }
        else{
            System.out.println("Data is not inserted into db");
            DialogBox.errorDialogBox("Record is not inserted into Database...");
        }
    }
    
    @FXML
    public void firstNameCol_onCommit(Event e){
        TableColumn.CellEditEvent<Manager, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Manager, String>) e;
        Manager manager = cellEditEvent.getRowValue();
        manager.setFirstName(cellEditEvent.getNewValue());
    }
    
    @FXML
    public void middleNameCol_onCommit(Event e){
        TableColumn.CellEditEvent<Manager, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Manager, String>) e;
        Manager manager = cellEditEvent.getRowValue();
        manager.setMiddleName(cellEditEvent.getNewValue());
    }
    
    @FXML
    public void lastNameCol_onCommit(Event e){
        TableColumn.CellEditEvent<Manager, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Manager, String>) e;
        Manager manager = cellEditEvent.getRowValue();
        manager.setLastName(cellEditEvent.getNewValue());
    }
    
    @FXML
    public void ratingCol_onCommit(){
        initColumns();
        manager_table.getSortOrder().add(manager_rating);
        manager_table.setItems(getManagerData());
    }
    
    public Team getTeamForManaging(){
        String selectTeamName = teamToManageMenu.getValue();
        System.out.println(selectTeamName);
        if(!teamData.isEmpty()){
            if(selectTeamName.equalsIgnoreCase("Select Team")){
                t = null;
            }
            else{
                ObservableList<Team> teams = FXCollections.observableArrayList();
                for(Team p : teamData){
                    if(selectTeamName.equals(p.getTeamName())){
                        t = p;
                        break;
                    }
                }
            }
        }
        return t;
    }
    
    @FXML
    public void onChangeComboBox(ActionEvent event){
        getTeamForManaging();
    }
}
