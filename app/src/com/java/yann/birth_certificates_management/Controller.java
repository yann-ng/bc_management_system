package com.java.yann.birth_certificates_management;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;



import java.net.URL;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Date;


public class Controller implements Initializable {

    @FXML
    private TextField txtF_search;

    @FXML
    private TableView<TheTable> tableView;

    @FXML
    private TableColumn<TheTable, String> fullName;

    @FXML
    private TableColumn<TheTable, String> gender;

    @FXML
    private TableColumn<TheTable, String> place_of_birth;

    @FXML
    private TableColumn<TheTable, Date> date_of_birth;

    ObservableList<TheTable> DB_list;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        place_of_birth.setCellValueFactory(new PropertyValueFactory<>("place_of_birth"));
        date_of_birth.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        DB_list = MysqlConnect.getTableData();
        tableView.setItems(DB_list);
    }
    public void populataTableView(String keyword, ObservableList<TheTable> listA)
    {
        fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        place_of_birth.setCellValueFactory(new PropertyValueFactory<>("place_of_birth"));
        date_of_birth.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        listA = MysqlConnect.searchData(keyword);
        tableView.setItems(listA);
    }


    public void searchAction(ActionEvent actionEvent)
    {
        ObservableList<TheTable> listB = null ;

        String keyword = txtF_search.getText().strip();
        populataTableView(keyword, listB);
    }

    public void openAddBC(MouseEvent mouseEvent) throws Exception
    {
        Stage stageGetACopy = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("assets/fxml/get_a_copy.fxml"));
        stageGetACopy.setTitle("Get a copy of a birth certificate");
        stageGetACopy.setResizable(false);
        stageGetACopy.initModality(Modality.APPLICATION_MODAL);
        Scene sceneGetACopy = new Scene(root);
        stageGetACopy.setScene(sceneGetACopy);
        stageGetACopy.show();
    }
}
