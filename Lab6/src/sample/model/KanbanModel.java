package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KanbanModel {
    private ObservableList<Task> toDoData = FXCollections.observableArrayList();
    private ObservableList<Task> inProgressData = FXCollections.observableArrayList();
    private ObservableList<Task> doneData = FXCollections.observableArrayList();

    public ObservableList<Task> getToDoData(){
        return toDoData;
    }

    public ObservableList<Task> getInProgressData(){
        return inProgressData;
    }

    public ObservableList<Task> getDoneData(){
        return doneData;
    }
}
