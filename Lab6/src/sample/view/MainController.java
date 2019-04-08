package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.MainApp;
import sample.model.Task;

public class MainController {
    @FXML
    private TableView<Task> toDoTable;
    @FXML
    private TableView<Task> inProgressTable;
    @FXML
    private TableView<Task> doneTable;

    @FXML
    private TableColumn<Task, String> toDoColumn;
    @FXML
    private TableColumn<Task, String> inProgressColumn;
    @FXML
    private TableColumn<Task, String> doneColumn;

    private MainApp mainApp;


    @FXML
    private void initialize(){
        toDoColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        inProgressColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        doneColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
    }

    @FXML
    private void handleNewTask(){
        Task tmpTask = new Task();
        boolean okClicked = mainApp.showEditTaskDialog(tmpTask);
        if (okClicked){
            mainApp.getKanbanModel().getToDoData().add(tmpTask);
        }
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        // Add observable lists data to the tables
        toDoTable.setItems(mainApp.getKanbanModel().getToDoData());
        inProgressTable.setItems(mainApp.getKanbanModel().getInProgressData());
        doneTable.setItems(mainApp.getKanbanModel().getDoneData());
    }
}
