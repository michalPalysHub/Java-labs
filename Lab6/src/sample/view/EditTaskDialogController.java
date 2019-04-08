package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Task;
import sample.util.DateUtil;

public class EditTaskDialogController {
    @FXML
    private TextField titleField;
    @FXML
    private TextField priorityField;
    @FXML
    private TextField expDateField;
    @FXML
    private TextArea taskTextArea;

    private Stage dialogStage;
    private Task task;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    public void setTask(Task task){
        this.task = task;

        titleField.setText(task.getTitle());
        priorityField.setText(task.getPriority());
        expDateField.setText(DateUtil.format(task.getExpDate()));
        expDateField.setPromptText("dd.mm.yyyy");
        taskTextArea.setText(task.getTaskText());
    }

    public boolean isOkClicked(){
        return okClicked;
    }

    private boolean isInputInvalid(){
        String errorMessage="";

        if (titleField.getText() == null || titleField.getText().length() == 0){
            errorMessage += "No valid title!\n";
        }
        if (priorityField.getText() == null || priorityField.getText().length() == 0){
            errorMessage += "No valid priority!\n";
        }
        if (taskTextArea.getText() == null || taskTextArea.getText().length() == 0){
            errorMessage += "No valid task text!\n";
        }
        if (expDateField.getText() == null || expDateField.getText().length() == 0){
            errorMessage += "No valid expiration date!\n";
        } else {
            if (!DateUtil.validDate(expDateField.getText())){
                errorMessage += "No valid expiration date -> use format dd.mm.yyyy";
            }
        }

        if (errorMessage.length() == 0){
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void handleOk(){
        if (isInputInvalid()){
            task.setTitle(titleField.getText());
            task.setPriority(priorityField.getText());
            task.setExpDate(DateUtil.parse(expDateField.getText()));
            task.setTaskText(taskTextArea.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel(){
        dialogStage.close();
    }
}
