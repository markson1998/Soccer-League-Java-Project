package application.gui.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import application.entities.Player;
import application.entities.controllers.PlayerController;
import javafx.scene.control.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PlayerWindowController implements Initializable {


    @FXML
    private Label welcome;
    @FXML
    private TableView<Player> player_table;
    @FXML
    private TableColumn<Player, String> player_firstname;
    @FXML
    private TableColumn<Player, String> player_middlename;
    @FXML
    private TableColumn<Player, String> player_lastname;
    @FXML
    private TableColumn<Player, String> player_phone;
    @FXML
    private TableColumn<Player, String> player_email;
    @FXML
    private TableColumn<Player, Integer> goals_in_year;
    @FXML
    private TableColumn<Player, Boolean> column_golie;
    @FXML
    private TableColumn<Player, Integer> defended_goals;
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
    private TextField firstNameField;
    @FXML
    private TextField middleNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private Button saveButton;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField totalGoalsField;
    @FXML
    private TextField goalsDefendedField;
    @FXML
    private MenuButton orderByButton;
    @FXML
    private RadioButton trueRadioBtn;
    @FXML
    private RadioButton falseRadioBtn;
    
    Player selectedPlayer;
    
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        firstNameField.setEditable(false);
        middleNameField.setEditable(false);
        lastNameField.setEditable(false);
        phoneField.setEditable(false);
        emailField.setEditable(false);
        totalGoalsField.setEditable(false);
        goalsDefendedField.setEditable(false);
        displayDataToTableView();
        editButton.setDisable(true);
        removeButton.setDisable(true);
    }   
    
    public void displayDataToTableView(){
        initColumns();
        player_table.setItems(getPlayersData());
    }
    
    @FXML
    public void getSelectedRowData(){
        player_table.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                if(player_table.getSelectionModel().getSelectedItem() != null){
                    editButton.setDisable(false);
                    removeButton.setDisable(false);
                    selectedPlayer = player_table.getSelectionModel().getSelectedItem();
                    firstNameField.setText(selectedPlayer.getFirstName());
                    middleNameField.setText(selectedPlayer.getMiddleName());
                    lastNameField.setText(selectedPlayer.getLastName());
                    phoneField.setText(selectedPlayer.getPhone());
                    emailField.setText(selectedPlayer.getEmail());
                    totalGoalsField.setText(String.valueOf(selectedPlayer.getNumberOfGoalsInCurrentYear()));
                    if(selectedPlayer.isGoalie()){
                        trueRadioBtn.setSelected(true);
                        falseRadioBtn.setSelected(false);
                    }
                    else{
                        trueRadioBtn.setSelected(false);
                        falseRadioBtn.setSelected(true);
                    }
                    goalsDefendedField.setText(String.valueOf(selectedPlayer.getDefendedGoals()));
                }
            }
        });
    }

    public void initColumns(){
        player_firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        player_middlename.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        player_lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        player_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        player_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        goals_in_year.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsInCurrentYear"));
        column_golie.setCellValueFactory(new PropertyValueFactory<>("goalie"));
        defended_goals.setCellValueFactory(new PropertyValueFactory<>("defendedGoals"));
    }
    
    private ObservableList<Player> playerData;
    private PlayerController playerController;
    
    public ObservableList<Player> getPlayersData(){
        playerController = new PlayerController();
        playerData = FXCollections.observableArrayList(playerController.getPlayerData());
        if(playerData == null){
            return FXCollections.observableArrayList();
        }
        return playerData;
    }
    
    public void resetFields(){
        firstNameField.setText("");
        middleNameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        totalGoalsField.setText("");
        goalsDefendedField.setText("");
        falseRadioBtn.setSelected(false);
        trueRadioBtn.setSelected(false);
        
        firstNameField.setEditable(false);
        middleNameField.setEditable(false);
        lastNameField.setEditable(false);
        phoneField.setEditable(false);
        emailField.setEditable(false);
        totalGoalsField.setEditable(false);
        goalsDefendedField.setEditable(false);
        
        editButton.setDisable(false);
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
    private void addPlayerData(ActionEvent event) {
        updateButton.setVisible(false);
        saveButton.setVisible(true);
        firstNameField.setEditable(true);
        middleNameField.setEditable(true);
        lastNameField.setEditable(true);
        phoneField.setEditable(true);
        emailField.setEditable(true);
        totalGoalsField.setEditable(true);
        goalsDefendedField.setEditable(false);
        
        firstNameField.setText("");
        middleNameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        totalGoalsField.setText("");
        goalsDefendedField.setText("");
        falseRadioBtn.setSelected(false);
        trueRadioBtn.setSelected(false);
        
        firstNameField.requestFocus();
        editButton.setDisable(true);
    }

    @FXML
    private void editPlayerButtonAction(ActionEvent event) {
        saveButton.setVisible(false);
        updateButton.setVisible(true);
        firstNameField.setEditable(true);
        middleNameField.setEditable(true);
        lastNameField.setEditable(true);
        phoneField.setEditable(true);
        emailField.setEditable(true);
        totalGoalsField.setEditable(true);
        goalsDefendedField.setEditable(true);
        firstNameField.requestFocus();
    }

    @FXML
    private void removePlayerData(ActionEvent event) {
        if(playerController.removePlayerData(selectedPlayer.getPlayer_id())){
            System.out.println(selectedPlayer.toString());
            System.out.println("Data Deleted from db");
            DialogBox.infoDialogBox("Success", "Record Has be deleted Successfully..");
            removeButton.setDisable(true);
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
    private void updatePlayerData(ActionEvent event) {
        selectedPlayer.setFirstName(firstNameField.getText().toString());
        selectedPlayer.setMiddleName(middleNameField.getText().toString());
        selectedPlayer.setLastName(lastNameField.getText().toString());
        selectedPlayer.setPhone(phoneField.getText().toString());
        selectedPlayer.setEmail(emailField.getText().toString());
        selectedPlayer.setNumberOfGoalsInCurrentYear(Integer.parseInt(totalGoalsField.getText().toString()));
        if(trueRadioBtn.isSelected()){
            selectedPlayer.setGoalie(true);
            selectedPlayer.setDefendedGoals(Integer.parseInt(goalsDefendedField.getText().toString()));
        }
        
        if(falseRadioBtn.isSelected()){
            selectedPlayer.setGoalie(false);
            selectedPlayer.setDefendedGoals(0);
        }
        
        if(playerController.updatePlayerData(selectedPlayer, selectedPlayer.getPlayer_id())){
            System.out.println(selectedPlayer.toString());
            System.out.println("Data updated into db");
            updateButton.setVisible(false);
            resetFields();
            DialogBox.infoDialogBox("Success", "Record Has Been Updated Successfully...");
            displayDataToTableView();
            editButton.setDisable(true);
        }
        else{
            System.out.println("Data is not updated");
            DialogBox.errorDialogBox("Record is not Updated...");
        }
    }
    
    @FXML
    private void trueGoalieBtnAction(ActionEvent event){
        if(trueRadioBtn.isSelected()){
            falseRadioBtn.setSelected(false);
            goalsDefendedField.setEditable(true);
            goalsDefendedField.requestFocus();
        }
    }
    
    @FXML
    private void falseGoalieBtnAction(ActionEvent event){
        if(falseRadioBtn.isSelected()){
            trueRadioBtn.setSelected(false);
            goalsDefendedField.setEditable(false);
        }
    }

    @FXML
    private void savePlayerData(ActionEvent event) {
        Player player = new Player();
        
        player.setFirstName(firstNameField.getText().toString());
        player.setMiddleName(middleNameField.getText().toString());
        player.setLastName(lastNameField.getText().toString());
        player.setPhone(phoneField.getText().toString());
        player.setEmail(emailField.getText().toString());
        player.setNumberOfGoalsInCurrentYear(Integer.parseInt(totalGoalsField.getText().toString()));
        if(trueRadioBtn.isSelected()){
            player.setGoalie(true);
            player.setDefendedGoals(Integer.parseInt(goalsDefendedField.getText().toString()));
        }
        
        if(falseRadioBtn.isSelected()){
            player.setGoalie(false);
        }

        if(playerController.insertPlayerData(player)){
            System.out.println("Data inserted into db");
            saveButton.setVisible(false);
            resetFields();
            System.out.println(player.toString());
            displayDataToTableView();
            editButton.setDisable(true);
        }
        else{
            System.out.println("Data is not inserted into db");
            DialogBox.errorDialogBox("Record is not inserted into Database...");
        }
    }
    
    @FXML
    public void onDefaultActive(){
        displayDataToTableView();
    }
    
    @FXML
    public void firstNameCol_onCommit(Event e){
        CellEditEvent<Player, String> cellEditEvent;
        cellEditEvent = (CellEditEvent<Player, String>) e;
        Player player = cellEditEvent.getRowValue();
        player.setFirstName(cellEditEvent.getNewValue());
    }
    
    @FXML
    public void middleNameCol_onCommit(){
        System.out.println("In Middle");
        initColumns();
        player_table.getSortOrder().add(player_middlename);
        player_table.setItems(getPlayersData());
    }
    
    @FXML
    public void lastNameCol_onCommit(){
        System.out.println("In last");
        initColumns();
        player_table.getSortOrder().add(player_lastname);
        player_table.setItems(getPlayersData());
    }
}