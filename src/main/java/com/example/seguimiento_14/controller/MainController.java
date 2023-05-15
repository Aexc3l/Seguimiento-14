package com.example.seguimiento_14.controller;

import com.example.seguimiento_14.MainApp;
import com.example.seguimiento_14.model.Registry;
import com.example.seguimiento_14.model.RegistryList;
import com.example.seguimiento_14.model.Type;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TableView<Registry> financeTable;

    @FXML
    private TableColumn<Registry, Double> amountColumn;

    @FXML
    private TableColumn<Registry, Type> typeColumn;

    @FXML
    private TableColumn<Registry, String> descriptionColumn;

    @FXML
    private TableColumn<Registry, Calendar> dateColumn;

    @FXML
    private Label balanceId;

    @FXML
    private Button registerShow;

    @FXML
    private Button registerShowC;

    @FXML
    private Button registerShowInc;

    @FXML
    private Button homePage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("typeC"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));


        financeTable.setItems(RegistryList.getInstance().getRegistries());
        String sc = balanceId.getText();
        balanceId.setText(sc + RegistryList.getInstance().getBalance());

        registerShow.setOnAction(action -> {
            financeTable.setItems(RegistryList.getInstance().getRegistries());
            dateColumn.setSortType(TableColumn.SortType.DESCENDING);
            typeColumn.setSortType(TableColumn.SortType.DESCENDING);
            descriptionColumn.setSortType(TableColumn.SortType.DESCENDING);
            amountColumn.setSortType(TableColumn.SortType.DESCENDING);
        });

        registerShowC.setOnAction(action -> {
            financeTable.setItems(RegistryList.getInstance().getCost());
            dateColumn.setSortType(TableColumn.SortType.DESCENDING);
            typeColumn.setSortType(TableColumn.SortType.DESCENDING);
            descriptionColumn.setSortType(TableColumn.SortType.DESCENDING);
            amountColumn.setSortType(TableColumn.SortType.DESCENDING);
        });

        registerShowInc.setOnAction(action -> {
            financeTable.setItems(RegistryList.getInstance().getIncomes());
            dateColumn.setSortType(TableColumn.SortType.DESCENDING);
            typeColumn.setSortType(TableColumn.SortType.DESCENDING);
            descriptionColumn.setSortType(TableColumn.SortType.DESCENDING);
            amountColumn.setSortType(TableColumn.SortType.DESCENDING);
        });

        homePage.setOnAction(action -> {
            Stage stage = (Stage) this.homePage.getScene().getWindow();
            stage.close();
            MainApp.openStage("register-view.fxml");
        });
    }
}
