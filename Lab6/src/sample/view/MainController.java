package sample.view;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
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

        // Set context menu
        toDoTable.setRowFactory(
                tableView -> {
                    final TableRow<Task> row = new TableRow<>();
                    final ContextMenu rowMenu = new ContextMenu();
                    MenuItem editItem = new MenuItem("Edit");
                    editItem.setOnAction(e -> {
                        Task selectedTask = toDoTable.getSelectionModel().getSelectedItem();
                        if (selectedTask != null) {
                            mainApp.showEditTaskDialog(selectedTask);
                        }});
                    MenuItem removeItem = new MenuItem("Delete");
                    removeItem.setOnAction(event -> toDoTable.getItems().remove(row.getItem()));
                    rowMenu.getItems().addAll(editItem, removeItem);

                    row.contextMenuProperty().bind(
                            Bindings.when(Bindings.isNotNull(row.itemProperty()))
                                    .then(rowMenu)
                                    .otherwise((ContextMenu)null));
                    return row;
                });

        toDoTable.getColumns().forEach(this::addTooltipToColumnCells);
    }

    private <T> void addTooltipToColumnCells(TableColumn<Task,T> column) {

        Callback<TableColumn<Task, T>, TableCell<Task,T>> existingCellFactory
                = column.getCellFactory();

        column.setCellFactory(c -> {
            TableCell<Task, T> cell = existingCellFactory.call(c);

            Tooltip tooltip = new Tooltip();

            StringProperty tooltipString = new SimpleStringProperty("Title: " );

            tooltip.textProperty().bind(cell.itemProperty().asString());

            cell.setTooltip(tooltip);
            return cell ;
        });
    }

    @FXML
    private void handleNewTask(){
        Task tmpTask = new Task();
        boolean okClicked = mainApp.showEditTaskDialog(tmpTask);
        if (okClicked){
            mainApp.getKanbanModel().getToDoData().add(tmpTask);
        }
    }

    @FXML
    private void handleRightButton(){
        Task fromToDoToInProgress = toDoTable.getSelectionModel().getSelectedItem();

        if (fromToDoToInProgress != null) {
            inProgressTable.getItems().add(fromToDoToInProgress);
            toDoTable.getItems().remove(fromToDoToInProgress);
        }

        Task fromInProgressToDone = inProgressTable.getSelectionModel().getSelectedItem();

        if (fromInProgressToDone != null) {
            doneTable.getItems().add(fromInProgressToDone);
            inProgressTable.getItems().remove(fromInProgressToDone);
        }
    }

    @FXML
    private void handleLeftButton(){
        Task fromInProgressToToDo = inProgressTable.getSelectionModel().getSelectedItem();

        if (fromInProgressToToDo != null) {
            toDoTable.getItems().add(fromInProgressToToDo);
            inProgressTable.getItems().remove(fromInProgressToToDo);
        }

        Task fromDoneToInProgress = doneTable.getSelectionModel().getSelectedItem();

        if (fromDoneToInProgress != null) {
            inProgressTable.getItems().add(fromDoneToInProgress);
            doneTable.getItems().remove(fromDoneToInProgress);
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
