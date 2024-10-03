package com.java.yann.birth_certificates_management;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;

public class ControllerGetCopy {

    @FXML
    TextField textF_fullName, textF_directory;
    @FXML
    Label lbl_copyMsg;

    public void copyBC(ActionEvent actionEvent) throws Exception {
        String BCname = textF_fullName.getText();
        String destinationDirectory = textF_directory.getText();
        String projectDirectory = System.getProperty("user.dir");
        String inProjectDir = "\\src\\com\\java\\yann\\birth_certificates_management\\assets\\certificates\\";
        String directory_wo_file = projectDirectory + inProjectDir;


        ObservableList<TheTable> listSearch = null;
        listSearch = MysqlConnect.searchData(BCname);

        if (listSearch.size() > 0)
        {
            String completeDirectory = directory_wo_file + BCname + ".pdf";
            String completeDestination = destinationDirectory + "\\" + BCname + ".pdf";

            File to_copy = new File(completeDirectory);
            File to_destination = new File(completeDestination);
            try {
                Files.copy(to_copy.toPath(), to_destination.toPath());
                lbl_copyMsg.setText("BIRTH CERTIFICATE COPIED.");
                lbl_copyMsg.setTextFill(Color.GREEN);
                lbl_copyMsg.setVisible(true);
                System.out.println("Done, copied succesfully!");
            } catch (FileAlreadyExistsException e) {
                lbl_copyMsg.setText("FILE WITH SAME NAME EXIST IN DESTINATION.");
                lbl_copyMsg.setTextFill(Color.RED);
                lbl_copyMsg.setVisible(true);
            }
        }
        else
        {
            lbl_copyMsg.setText("VERIFY THE NAME ENTERED");
            lbl_copyMsg.setTextFill(Color.RED);
            lbl_copyMsg.setVisible(true);
        }

    }

    public void chooseDirectory(ActionEvent actionEvent) throws Exception {
        Stage openThings = new Stage();
        DirectoryChooser browseTo = new DirectoryChooser();
        // browseTo.setInitialDirectory(new File("src"));
        File selectDirectory = browseTo.showDialog(openThings);
        textF_directory.setText(selectDirectory.getAbsolutePath());
    }
}