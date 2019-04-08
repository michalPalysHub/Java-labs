package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import sample.MainApp;

public class RootLayoutController {

    private MainApp mainApp;

    @FXML
    private void handleClose(){
        mainApp.getPrimaryStage().close();
    }

    @FXML
    private void handleAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("About author");
        alert.setHeaderText("This application is brought to you by:");
        alert.setContentText("Michał Pałys\n" +
                "AGH University of Science and Technology\n" +
                "Faculty od Metals Engineering and Industrial Computer Science\n" +
                "Applied Computer Science");

        alert.showAndWait();
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
}
