package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
      Parent root = FXMLLoader.load( this.getClass().getResource("/view/Book.fxml"));
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.show();
      stage.setTitle("Book Form");
    }

    @FXML
    void btnBorrowingsOnAction(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load( this.getClass().getResource("/view/Borrowings.fxml"));
       Stage stage = new Stage();
       stage.setScene(new Scene(root));
       stage.show();
       stage.setTitle("Borrowings Form");
    }

    @FXML
    void btnCategoryOnAction(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load( this.getClass().getResource("/view/Category.fxml"));
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();
    stage.setTitle("Category Form");
    }

    @FXML
    void btnMemberOnAction(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load( this.getClass().getResource("/view/Member.fxml"));
       Stage stage = new Stage();
       stage.setScene(new Scene(root));
       stage.show();
       stage.setTitle("Member Form");
    }
}
