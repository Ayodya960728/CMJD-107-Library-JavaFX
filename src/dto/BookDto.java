package dto;

public class BookDto {
    
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private Integer year;
    private Integer category_id;

    public BookDto() {
    }

    public BookDto(Integer id, String title, String author, String publisher, Integer year, Integer category_id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.category_id = category_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "BookDto [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", year="
                + year + ", category_id=" + category_id + "]";
    }

    

    
}
