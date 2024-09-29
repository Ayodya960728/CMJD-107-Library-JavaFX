package tm;

import javafx.scene.control.Button;

public class BookTM {
    
    private int bookId;
    private String bookTitle;
    private String author;
    private String publisher;
    private int year;
    private int categoryID;
    private Button btnDelete;

    public BookTM() {
    }

    public BookTM(int bookId, String bookTitle, String author, String publisher, int year, int categoryID,
            Button btnDelete) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.categoryID = categoryID;
        this.btnDelete = btnDelete;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "BookTM [bookId=" + bookId + ", bookTitle=" + bookTitle + ", author=" + author + ", publisher="
                + publisher + ", year=" + year + ", categoryID=" + categoryID + ", btnDelete=" + btnDelete + "]";
    }
    
    
    
}
