package sample.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class KanbanModel {

    private final StringProperty title;
    private final ObjectProperty<LocalDate> expDate;
    private final StringProperty priority; // TODO: change this to "EnumProperty" or sth like that
    private final StringProperty taskText;

    public KanbanModel(){
        this.title = new SimpleStringProperty("");
        // TODO: change expDate to show actual date by default
        this.expDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(2019, 4, 8));
        this.priority = new SimpleStringProperty("Low");
        this.taskText = new SimpleStringProperty("");
    }

    // methods for title
    public String getTitle(){
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title){
        this.title.set(title);
    }

    // methods for expDate
    public LocalDate getExpDate(){
        return expDate.get();
    }

    public ObjectProperty<LocalDate> expDateProperty(){
        return expDate;
    }

    public void setExpDate(LocalDate expDate){
        this.expDate.set(expDate);
    }

    // methods for priority
    public String getPriority() {
        return priority.get();
    }

    public StringProperty priorityProperty() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority.set(priority);
    }

    // methods for taskText
    public String getTaskText() {
        return taskText.get();
    }

    public StringProperty taskTextProperty() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText.set(taskText);
    }

}
