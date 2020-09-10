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

public class TeamWindowController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private TableView<Team> team_table;
    @FXML
    private TableColumn<Team, String> team_name;
    @FXML
    private TableColumn<Team, String> team_manager;
    @FXML
    private TableColumn<Team, String> team_jersey_color;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button backButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField teamNameField;
    @FXML
    private TextField teamJerseyColorField;
    @FXML
    private ComboBox<String> teamManagerMenu;
    
    Team selectedTeam;
    ManagerWindowController managerWindowController;
    private ObservableList<Manager> managerData;
    Manager m;
    ManagerController managerController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teamNameField.setEditable(false);
        teamManagerMenu.setDisable(true);
        teamManagerMenu.setStyle("-fx-opacity: 1");
        teamJerseyColorField.setEditable(false);
        displayDataToTableView();
        editButton.setDisable(true);
        removeButton.setDisable(true);
        
        managerWindowController = new ManagerWindowController();
        managerData = managerWindowController.getManagerData();
        
        if(!managerData.isEmpty()){
            ObservableList<String> options = FXCollections.observableArrayList();
            
            for(Manager p : managerData){
                options.add(p.getName());
            }
            teamManagerMenu.getItems().addAll(options);
        }
        
    }    
    
    public void displayDataToTableView(){
        initColumns();
        team_table.setItems(getTeamData());
    }
    
    @FXML
    public void getSelectedRowData(){
        team_table.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                if(team_table.getSelectionModel().getSelectedItem() != null){
                    editButton.setDisable(false);
                    removeButton.setDisable(false);
                    selectedTeam = team_table.getSelectionModel().getSelectedItem();
                    teamNameField.setText(selectedTeam.getTeamName());
                    teamJerseyColorField.setText(selectedTeam.getJerseyColor());
                    try{
                        teamManagerMenu.setValue(selectedTeam.getManager().getName());
                    }
                    catch(Exception e){
                        teamManagerMenu.setValue("Select Manager");
                    }
                    
                }
            }
        });
    }

    public void initColumns(){
        team_name.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        try{
            team_manager.setCellValueFactory(new PropertyValueFactory<>("manager"));
        }
        catch(Exception e){
            
        }
        team_jersey_color.setCellValueFactory(new PropertyValueFactory<>("jerseyColor"));
    }
    
    private ObservableList<Team> teamData;
    private TeamController teamController;
    
    public ObservableList<Team> getTeamData(){
        teamController = new TeamController();
        teamData = FXCollections.observableArrayList(teamController.getTeamData());
        if(teamData == null){
            return FXCollections.observableArrayList();
        }
        return teamData;
    }
    
    public void resetFields(){
        teamNameField.setText("");
        teamManagerMenu.setValue("Select Manager");
        teamJerseyColorField.setText("");
        
        teamNameField.setEditable(false);
        teamManagerMenu.setDisable(true);
        teamJerseyColorField.setEditable(false);
        
        editButton.setDisable(false);
    }
    
    @FXML
    private void addTeamBtn(ActionEvent event) {
        updateButton.setVisible(false);
        saveButton.setVisible(true);
        teamNameField.setEditable(true);
        teamManagerMenu.setDisable(false);
        teamJerseyColorField.setEditable(true);
        
        teamNameField.setText("");
        teamManagerMenu.setValue("Select Manager");
        teamJerseyColorField.setText("");
        
        teamNameField.requestFocus();
        editButton.setDisable(true);
        removeButton.setDisable(true);
    }

    @FXML
    private void editTeamButtonAction(ActionEvent event) {
        saveButton.setVisible(false);
        updateButton.setVisible(true);
        removeButton.setDisable(true);
        teamNameField.setEditable(true);
        teamManagerMenu.setDisable(false);
        teamJerseyColorField.setEditable(true);
        teamNameField.requestFocus();
    }

    @FXML
    private void removeTeamData(ActionEvent event) {
        if(teamController.removeTeamData(selectedTeam.getTeam_id())){
            System.out.println(selectedTeam.toString());
            System.out.println("Team Deleted from db");
            DialogBox.infoDialogBox("Success", "Team Has be deleted Successfully..");
            removeButton.setDisable(true);
            resetFields();
            displayDataToTableView();
            editButton.setDisable(true);
        }
        else{
            System.out.println("Team is not Deleted...");
            DialogBox.errorDialogBox("Team is not Deleted...");
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
    private void updateTeamData(ActionEvent event) {
        selectedTeam.setTeamName(teamNameField.getText().toString());
        selectedTeam.setManager(getManagerForManaging());
        selectedTeam.setJerseyColor(teamJerseyColorField.getText().toString());
        
        
        if(teamController.updateTeamData(selectedTeam, selectedTeam.getTeam_id())){
            System.out.println(selectedTeam.toString());
            System.out.println("Team updated into db");
            updateButton.setVisible(false);
            resetFields();
            DialogBox.infoDialogBox("Success", "Team Record Has Been Updated Successfully...");
            displayDataToTableView();
            editButton.setDisable(true);
            removeButton.setDisable(true);
        }
        else{
            System.out.println("Team Data is not updated");
            DialogBox.errorDialogBox("Team Record is not Updated...");
        }
    }

    @FXML
    private void saveTeamData(ActionEvent event) {
        Team team = new Team();
        
        team.setTeamName(teamNameField.getText().toString());
        team.setManager(getManagerForManaging());
        team.setJerseyColor(teamJerseyColorField.getText().toString());
        
        teamData = getTeamData();
        boolean isJerseyUnique = true;
        for(Team tm : teamData){
            if(tm.getJerseyColor().equalsIgnoreCase(team.getJerseyColor())){
                DialogBox.errorDialogBox("Team Record is not saved to database.\nTeam Jersey Color Must be Unique...");
                isJerseyUnique = false;
                break;
            }
        }
        
        if(isJerseyUnique){
            if(teamController.insertTeamData(team)){
                System.out.println("Team Data inserted into db");
                saveButton.setVisible(false);
                resetFields();
                System.out.println(team.toString());
                displayDataToTableView();
                editButton.setDisable(true);
            }
            else{
                System.out.println("Team Data is not inserted into db");
                DialogBox.errorDialogBox("Team Record is not inserted into Database...");
            }
        }
    }
    
    public Manager getManagerForManaging(){
        String selectedManagerName = teamManagerMenu.getValue();
        System.out.println(selectedManagerName);
        if(!managerData.isEmpty()){
            if(selectedManagerName.equalsIgnoreCase("Select Manager")){
                m = null;
            }
            else{
                ObservableList<Manager> manager = FXCollections.observableArrayList();
                for(Manager p : managerData){
                    if(selectedManagerName.equals(p.getName())){
                        m = p;
                        break;
                    }
                }
            }
        }
        return m;
    }
    
    @FXML
    public void onComboBoxChange(ActionEvent event){
        getManagerForManaging();
    }
}
