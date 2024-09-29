package tm;

import javafx.scene.control.Button;

public class BorrowingsTM {
    private int book_id;
    private int member_id;
    private String borrow_date;
    private String due_date;
    private String return_date;
    private String fine;
    private Button btnDelete;
    
    public BorrowingsTM() {
    }

    public BorrowingsTM(int book_id, int member_id, String borrow_date, String due_date, String return_date,
            String fine, Button btnDelete) {
        this.book_id = book_id;
        this.member_id = member_id;
        this.borrow_date = borrow_date;
        this.due_date = due_date;
        this.return_date = return_date;
        this.fine = fine;
        this.btnDelete = btnDelete;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "BorrowingsTM [book_id=" + book_id + ", member_id=" + member_id + ", borrow_date=" + borrow_date
                + ", due_date=" + due_date + ", return_date=" + return_date + ", fine=" + fine + ", btnDelete="
                + btnDelete + "]";
    }

    
}
