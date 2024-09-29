package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import dto.MemberDto;
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
import tm.MemberTM;

public class MemberController {

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtName;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    private TableView<MemberTM> tblMember;

    @FXML
    private TableColumn<MemberTM, String> colAction;

    @FXML
    private TableColumn<MemberTM, Integer> colMemberId;

    @FXML
    private TableColumn<MemberTM, String> colName;

    @FXML
    private TableColumn<MemberTM, String> colPhone;

    public void initialize() throws ClassNotFoundException, SQLException {
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        getAllMember();
    }

    public void getAllMember() throws ClassNotFoundException, SQLException {

        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM members");
        ResultSet memberSet = statement.executeQuery();

        ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();

        while (memberSet.next()) {
            MemberDto memberDto = new MemberDto(
                memberSet.getInt(1),
                memberSet.getString(2),
                memberSet.getString(3)
            );
            //System.out.println(memberDto);
            memberList.add(memberDto);
        }

        //System.out.println("memberList : "+memberList);

        ObservableList<MemberTM> memberTMList = FXCollections.observableArrayList();

        for(MemberDto memberDto:memberList) {
            Button button = new Button("Delete");
           MemberTM memberTM = new MemberTM(
                       memberDto.getId(), 
                       memberDto.getName(), 
                       memberDto.getPhone(),
                       button);

            memberTMList.add(memberTM);
        }

        //System.out.println(memberTMList);

        tblMember.setItems(memberTMList);
        
    }


    @FXML
    void btnSaveOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        System.out.println("Member_Id : "+txtMemberId.getText());
        System.out.println("Name : "+txtName.getText());
        System.out.println("Contact : "+txtPhone.getText());

        int memberId= Integer.parseInt(txtMemberId.getText());
        String name= txtName.getText();
        String phone= txtPhone.getText();

        MemberDto memberDto = new MemberDto(memberId, name, phone);
        System.out.println(memberDto);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO members VALUES (?,?,?)");
        statement.setObject(1, memberDto.getId());
        statement.setObject(2, memberDto.getName());
        statement.setObject(3, memberDto.getPhone());

        int rows = statement.executeUpdate();   
        if(rows>0) {
            System.out.println("Members Saved Successfully!!");
            new Alert(Alert.AlertType.CONFIRMATION,"Members Saved Successfully!!").show();
        } else {
            System.out.println("Error While Saving Members");
            new Alert(Alert.AlertType.ERROR,"Error While Saving Members").show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnLoadAllMembersOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        getAllMember();
    }
}
