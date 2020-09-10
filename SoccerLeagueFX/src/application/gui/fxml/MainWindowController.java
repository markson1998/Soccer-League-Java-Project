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
import javafx.stage.Stage;


public class MainWindowController implements Initializable {
    
    @FXML
    private Label welcome;
    @FXML
    private Label mssg1;
    
    @FXML
    private void playerButtonAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/application/gui/fxml/PlayerWindow.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/application/gui/style/AdminPage.css").toExternalForm());
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setMaximized(true);
            stage.setTitle("Soccer League: Players");
            stage.setScene(scene);
            stage.show();
          
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void managerButtonAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/application/gui/fxml/ManagerWindow.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/application/gui/style/AdminPage.css").toExternalForm());
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setMaximized(true);
            stage.setTitle("Soccer League: Managers");
            stage.setScene(scene);
            stage.show();
           
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void teamButtonAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/application/gui/fxml/TeamWindow.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/application/gui/style/AdminPage.css").toExternalForm());
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setMaximized(true);
            stage.setTitle("Soccer League: Teams");
            stage.setScene(scene);
            stage.show();
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
