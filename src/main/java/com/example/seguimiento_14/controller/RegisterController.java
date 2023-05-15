package com.example.seguimiento_14.controller;

import com.example.seguimiento_14.MainApp;
import com.example.seguimiento_14.model.Registry;
import com.example.seguimiento_14.model.RegistryList;
import com.example.seguimiento_14.model.Type;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {
    @FXML
    private TextField costId;

    @FXML
    private TextField incomeId;

    @FXML
    private TextField dateId;

    @FXML
    private TextArea descriptionId;

    @FXML
    private Button registerCost;

    @FXML
    private Button registerIncome;

    @FXML
    private Button deleteRegister;

    @FXML
    private Button showRegister;

    @FXML
    private Label addesc;

    @FXML
    private Label adddate;

    @FXML
    private Label addincome;

    @FXML
    private Label adcost;

    @FXML
    private Label quantityid;

    @FXML
    private Label date;

    @FXML
    private Label description1;

    @FXML
    private TextField quantity;

    @FXML
    private TextField calendar;

    @FXML
    private TextArea description2;

    public void registerCost(ActionEvent actionEvent) {
        if (dateId.getText().isEmpty() || descriptionId.getText().isEmpty() || costId.getText().isEmpty()) {
            setAllDisabled();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Input is Empty");
            alert.showAndWait();
            return;
        }

        double value = Double.parseDouble(costId.getText());
        String desc = descriptionId.getText();
        String date = dateId.getText();
        if (!convertToCalendar(date)) {
            setAllDisabled();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("The Date is incorrect");
            alert.showAndWait();
            return;
        }

        Registry registry = new Registry(value, desc, Type.COST, date);
        if (registry != null) {
            RegistryList.getInstance().getRegistries().add(registry);
        }
        setAllDisabled();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Registration has been done");
        alert.showAndWait();
        deleteRegister.setDisable(false);
        return;
    }

    public void registerIncome(ActionEvent actionEvent) {
        if (incomeId.getText().isEmpty() || descriptionId.getText().isEmpty() || dateId.getText().isEmpty()) {
            setAllDisabled();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Input is Empty");
            alert.showAndWait();
            return;
        }

        double value = Double.parseDouble(incomeId.getText());
        String desc = descriptionId.getText();
        String date = dateId.getText();
        if (!convertToCalendar(date)) {
            setAllDisabled();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("The Date is incorrect");
            alert.showAndWait();
            return;
        }

        Registry registry = new Registry(value, desc, Type.INCOME, date);
        if (registry != null) {
            RegistryList.getInstance().getRegistries().add(registry);
        }
        setAllDisabled();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Registration has been done");
        alert.showAndWait();
        deleteRegister.setDisable(false);
        return;
    }

    private boolean convertToCalendar(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFormat.parse(date));
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void setAllDisabled(){
        incomeId.setDisable(true);
        costId.setDisable(true);
        dateId.setDisable(true);
        descriptionId.setDisable(true);
    }

    @FXML
    public void actCostsRegister(ActionEvent actionEvent) {
        if (costId.isDisabled() && dateId.isDisabled() && descriptionId.isDisabled()){
            costId.setDisable(false);
            dateId.setDisable(false);
            descriptionId.setDisable(false);
        }else {
           registerCost(actionEvent);
        }
    }

    @FXML
    public void actCostsIncome(ActionEvent actionEvent) {
        if (incomeId.isDisabled() && dateId.isDisabled() && descriptionId.isDisabled()){
            incomeId.setDisable(false);
            dateId.setDisable(false);
            descriptionId.setDisable(false);
        }else {
            registerIncome(actionEvent);
        }
    }

    @FXML
    public void actCostsDelete(ActionEvent actionEvent) {
        //Disable All
        costId.setDisable(false);
        incomeId.setDisable(false);
        dateId.setDisable(false);
        descriptionId.setDisable(false);
        registerIncome.setDisable(false);
        registerCost.setDisable(false);

        //SetInvisible
        costId.setVisible(false);
        incomeId.setVisible(false);
        dateId.setVisible(false);
        descriptionId.setVisible(false);
        registerIncome.setVisible(false);
        registerCost.setVisible(false);
        adcost.setVisible(false);
        addesc.setVisible(false);
        adddate.setVisible(false);
        addincome.setVisible(false);

        //SetVisible
        quantityid.setVisible(true);
        quantity.setVisible(true);
        date.setVisible(true);
        calendar.setVisible(true);
        description1.setVisible(true);
        description2.setVisible(true);

        //Able All
        quantity.setDisable(false);
        calendar.setDisable(false);
        description2.setDisable(false);

        deleteRegister(actionEvent);
    }

    private void deleteRegister(ActionEvent actionEvent) {

        double value = Double.parseDouble(quantity.getText());
        String desc = description2.getText();
        String date = calendar.getText();
        if (!convertToCalendar(date)) {
            setAllDisabled();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("The Date is incorrect");
            alert.showAndWait();
        }
        if (quantity.getText().isEmpty() || description2.getText().isEmpty() || calendar.getText().isEmpty()) {
            setAllDisabled();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Input is Empty");
            alert.showAndWait();
        }else {
           if (RegistryList.getInstance().delete(date,value,desc)){
               setAllDisabled();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Success");
               alert.setContentText("Registration has been deleted");
               alert.showAndWait();
                return;
           }
        }
    }

    @FXML
    void viewRecords(ActionEvent event) {
        Stage stage = (Stage) this.showRegister.getScene().getWindow();
        stage.close();
        MainApp.openStage("main-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
