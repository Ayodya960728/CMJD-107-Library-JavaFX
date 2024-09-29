package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import dto.BookDto;
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
import tm.BookTM;

public class BookController {

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtCategory_Id;

    @FXML
    private TextField txtPublisher;

    @FXML
    private TextField txtYear;

    @FXML
    private TableView<BookTM> tblBook;

    @FXML
    private TableColumn<BookTM, String> colAction;

    @FXML
    private TableColumn<BookTM, String> colAuthor;

    @FXML
    private TableColumn<BookTM, Integer> colBookId;

    @FXML
    private TableColumn<BookTM, String> colBookTitle;

    @FXML
    private TableColumn<BookTM, Integer> colCategory_Id;

    @FXML
    private TableColumn<BookTM, String> colPublisher;

    @FXML
    private TableColumn<BookTM, Integer> colYear;

    public void initialize() throws ClassNotFoundException, SQLException {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colPublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colCategory_Id.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
        
        getAllBooks();
    }

    public void getAllBooks() throws ClassNotFoundException, SQLException {

        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM books");
        ResultSet bookSet = statement.executeQuery();

       ArrayList<BookDto> bookList = new ArrayList<BookDto>();

        while (bookSet.next()) {
            BookDto bookDto = new BookDto(
            bookSet.getInt(1), 
            bookSet.getString(2),
            bookSet.getString(3), 
            bookSet.getString(4), 
            bookSet.getInt(5),
            bookSet.getInt(6)
            );
           // System.out.println(bookDto);
            bookList.add(bookDto);
        }

       // System.out.println("bookList : "+bookList);

        ObservableList<BookTM> bookTMList = FXCollections.observableArrayList();

        for(BookDto bookDto:bookList) {
            Button button = new Button("Delete");
            BookTM bookTM = new BookTM(
                bookDto.getId(),
             bookDto.getTitle(), 
             bookDto.getAuthor(), 
             bookDto.getPublisher(), 
             bookDto.getYear(), 
             bookDto.getCategory_id(),
              button);

              bookTMList.add(bookTM);
        }

       // System.out.println(bookTMList);

        tblBook.setItems(bookTMList);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        System.out.println("Book_ID : "+txtBookId.getText());
        System.out.println("Title : "+txtBookTitle.getText());
        System.out.println("Author : "+txtAuthor.getText());
        System.out.println("Publisher : "+txtPublisher.getText());
        System.out.println("Year : "+txtYear.getText());
        System.out.println("Category_Id : "+txtCategory_Id.getText());

        int bookId= Integer.parseInt(txtBookId.getText());
        String title= txtBookTitle.getText();
        String author= txtAuthor.getText();
        String publisher= txtPublisher.getText();
        int year= Integer.parseInt(txtYear.getText());
        int categoryId= Integer.parseInt(txtCategory_Id.getText());

        BookDto bookDto = new BookDto(bookId,title,author,publisher,year,categoryId);
        //System.out.println(bookDto);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO books VALUES (?,?,?,?,?,?)");
        statement.setObject(1, bookDto.getId());
        statement.setObject(2, bookDto.getTitle());
        statement.setObject(3, bookDto.getAuthor());
        statement.setObject(4, bookDto.getPublisher());
        statement.setObject(5, bookDto.getYear());
        statement.setObject(6, bookDto.getCategory_id());

        int rows = statement.executeUpdate();
        if(rows>0) {
            System.out.println("Books Saved Successfully!!");
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved Successfully!!").show();
        } else {
            System.out.println("Error While Saving Books");
            new Alert(Alert.AlertType.ERROR,"Error While Saving Books").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnLoadAllBooksOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
       getAllBooks();
    }
}
