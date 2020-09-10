
package application.gui.fxml;

import javafx.scene.control.Alert;


public class DialogBox {
    public static void infoDialogBox(String boxTitle, String boxContentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(boxTitle);
        alert.setHeaderText(null);
        alert.setContentText(boxContentText);
        alert.showAndWait();
    }
    
    public static void errorDialogBox(String boxContentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText(boxContentText);
        alert.showAndWait();
    }
}
