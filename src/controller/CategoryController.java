package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import dto.CategoryDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tm.CategoryTM;

public class CategoryController {

     @FXML
    private TextField txtCategoryId;

    @FXML
    private TextField txtCategoryName;

    @FXML
    private TableView<CategoryTM> tblCategory;

    @FXML
    private TableColumn<CategoryTM, String> colAction;

    @FXML
    private TableColumn<CategoryTM, Integer> colCategoryID;

    @FXML
    private TableColumn<CategoryTM, String> colCategoryName;

    public void initialize() throws ClassNotFoundException, SQLException{
      colCategoryID.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
      colCategoryName.setCellValueFactory(new PropertyValueFactory<>("name"));
      colAction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

      getAllCategory();

    }

    public void getAllCategory() throws ClassNotFoundException, SQLException {

      PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM categories");
      ResultSet categorySet = statement.executeQuery();

      ArrayList<CategoryDto> categoryList = new ArrayList<CategoryDto>();
      

      while (categorySet.next()) {
        CategoryDto categoryDto = new CategoryDto(
           categorySet.getInt(1),
           categorySet.getString(2)
        );
       // System.out.println(categoryDto);
        categoryList.add(categoryDto);
      }

      //System.out.println("categoryList : "+categoryList);

      ObservableList<CategoryTM> categoryTMList = FXCollections.observableArrayList();

      for(CategoryDto categoryDto:categoryList){
        Button button = new Button("Delete");
        CategoryTM categoryTM = new CategoryTM(
           categoryDto.getCategoryID(), 
           categoryDto.getCategoryName(), 
           button);

        categoryTMList.add(categoryTM);
      }

      //System.out.println(categoryTMList);

      tblCategory.setItems(categoryTMList);
    }


    @FXML
    void btnSaveOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
         System.out.println("ID : "+txtCategoryId.getText());
         System.out.println("Name : "+txtCategoryName.getText());

         int id= Integer.parseInt(txtCategoryId.getText());
         String name= txtCategoryName.getText();

         CategoryDto categoryDto = new CategoryDto(id,name);
        // System.out.println(categoryDto);

         Connection connection = DBConnection.getInstance().getConnection();

         PreparedStatement statement = connection.prepareStatement("INSERT INTO categories VALUES (?,?)");
         statement.setObject(1, categoryDto.getCategoryID());
         statement.setObject(2, categoryDto.getCategoryName());

         int rows = statement.executeUpdate();
         if(rows>0){
            System.out.println("Category Saved Successfully!!");
            new Alert(Alert.AlertType.CONFIRMATION,"Category Saved Successfully!!").show();
         } else {
            System.out.println("Error While Saving Category");
            new Alert(Alert.AlertType.ERROR,"Error While Saving Category").show();
         }
    }

@FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnLoadAllCategoryOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
      getAllCategory();
   }

   @FXML
   void tblCategoryOnMouseClicked(MouseEvent event) throws SQLException {
}
}
