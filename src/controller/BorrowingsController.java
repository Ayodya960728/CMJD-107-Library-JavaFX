package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import dto.BorrowingsDto;
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
import tm.BorrowingsTM;

public class BorrowingsController {

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBorrow_Date;

    @FXML
    private TextField txtDue_Date;

    @FXML
    private TextField txtFine;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtReturn_Date;

    @FXML
    private TableView<BorrowingsTM> tblBorrowings;

    @FXML
    private TableColumn<BorrowingsTM, String> colAction;

    @FXML
    private TableColumn<BorrowingsTM, Integer> colBookId;

    @FXML
    private TableColumn<BorrowingsTM, String> colBorrow_Date;

    @FXML
    private TableColumn<BorrowingsTM, String> colDue_Date;

    @FXML
    private TableColumn<BorrowingsTM, String> colFine;

    @FXML
    private TableColumn<BorrowingsTM, Integer> colMemberId;

    @FXML
    private TableColumn<BorrowingsTM, String> colReturn_Date;

    @FXML
    void btnApproveBorrowingsOnAction(ActionEvent event) {

    }

    public void initialize() throws ClassNotFoundException, SQLException {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("member_id"));
        colBorrow_Date.setCellValueFactory(new PropertyValueFactory<>("borrow_date"));
        colDue_Date.setCellValueFactory(new PropertyValueFactory<>("due_date"));
        colReturn_Date.setCellValueFactory(new PropertyValueFactory<>("return_date"));
        colFine.setCellValueFactory(new PropertyValueFactory<>("fine"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        getAllBorrowings();
    }

    public void getAllBorrowings() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM borrowings");
        ResultSet borrowingSet = statement.executeQuery();

        ArrayList<BorrowingsDto> borrowingList = new ArrayList<BorrowingsDto>();

        while (borrowingSet.next()) {
            BorrowingsDto borrowingsDto = new BorrowingsDto(
                borrowingSet.getInt(1),
                borrowingSet.getInt(2),
                borrowingSet.getString(3),
                borrowingSet.getString(4),
                borrowingSet.getString(5),
                borrowingSet.getString(6)
            );

            //System.out.println(borrowingsDto);
            borrowingList.add(borrowingsDto);
        }

        //System.out.println("borrowingList : "+borrowingList);

        ObservableList<BorrowingsTM> borrowingsTMList = FXCollections.observableArrayList();

        for(BorrowingsDto borrowingsDto:borrowingList) {
            Button button = new Button("Delete");
            BorrowingsTM borrowingsTM = new BorrowingsTM(
                            borrowingsDto.getBook_id(), 
                            borrowingsDto.getMember_id(), 
                            borrowingsDto.getBorrow_date(), 
                            borrowingsDto.getDue_date(), 
                            borrowingsDto.getReturn_date(), 
                            borrowingsDto.getFine(), 
                            button);

                            borrowingsTMList.add(borrowingsTM);
        }

        //System.out.println(borrowingsTMList);

        tblBorrowings.setItems(borrowingsTMList);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        System.out.println("Book_Id : "+txtBookId.getText());
        System.out.println("Member_Id : "+txtMemberId.getText());
        System.out.println("Borrow_Date : "+txtBorrow_Date.getText());
        System.out.println("Due_Date : "+txtDue_Date.getText());
        System.out.println("Return_Date : "+txtReturn_Date.getText());
        System.out.println("Fine : "+txtFine.getText());

        int bookId= Integer.parseInt(txtBookId.getText());
        int memberId= Integer.parseInt(txtMemberId.getText());
        String borrowDate= txtBorrow_Date.getText();
        String dueDate= txtDue_Date.getText();
        String returnDate= txtReturn_Date.getText();
        String fine= txtFine.getText();

        BorrowingsDto borrowingsDto = new BorrowingsDto(bookId,memberId,borrowDate,dueDate,returnDate,fine);
        System.out.println(borrowingsDto);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO borrowings VALUES (?,?,?,?,?,?)");
        statement.setObject(1, borrowingsDto.getBook_id());
        statement.setObject(2, borrowingsDto.getMember_id());
        statement.setObject(3, borrowingsDto.getBorrow_date());
        statement.setObject(4, borrowingsDto.getDue_date());
        statement.setObject(5, borrowingsDto.getReturn_date());
        statement.setObject(6, borrowingsDto.getFine());

        int rows = statement.executeUpdate();
        if(rows>0) {
            System.out.println("Borrowings Saved Successfully!!");
            new Alert(Alert.AlertType.CONFIRMATION,"Borrowings Saved Successfully!!");
        } else {
            System.out.println("Error While Saving Borrowings");
            new Alert(Alert.AlertType.ERROR,"Error While Saving Borrowings");
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnLoadAllBorrowingsOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        getAllBorrowings();
    }
}
