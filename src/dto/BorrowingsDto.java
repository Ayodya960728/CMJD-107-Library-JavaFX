package dto;

public class BorrowingsDto {
    
    private Integer book_id;
    private Integer member_id;
    private String borrow_date;
    private String due_date;
    private String return_date;
    private String fine;
    
    public BorrowingsDto() {
    }

    public BorrowingsDto(Integer book_id, Integer member_id, String borrow_date, String due_date, String return_date,
            String fine) {
        this.book_id = book_id;
        this.member_id = member_id;
        this.borrow_date = borrow_date;
        this.due_date = due_date;
        this.return_date = return_date;
        this.fine = fine;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
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

    @Override
    public String toString() {
        return "BorrowingsDto [book_id=" + book_id + ", member_id=" + member_id + ", borrow_date=" + borrow_date
                + ", due_date=" + due_date + ", return_date=" + return_date + ", fine=" + fine + "]";
    }

    public MemberDto[] getMemberDtos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMemberDtos'");
    }

    
}
