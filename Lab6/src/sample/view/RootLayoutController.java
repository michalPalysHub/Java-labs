package sample.view;

import javafx.fxml.FXML;
import sample.MainApp;

public class RootLayoutController {

    private MainApp mainApp;

    @FXML
    private void handleClose(){
        mainApp.getPrimaryStage().close();
    }

    @FXML
    private void handleAbout(){

    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
}
