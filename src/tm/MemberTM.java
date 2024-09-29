package tm;

import javafx.scene.control.Button;

public class MemberTM {
    private int memberId;
    private String name;
    private String phone;
    private Button btnDelete;
    
    public MemberTM() {
    }

    public MemberTM(int memberId, String name, String phone, Button btnDelete) {
        this.memberId = memberId;
        this.name = name;
        this.phone = phone;
        this.btnDelete = btnDelete;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "MemberTM [memberId=" + memberId + ", name=" + name + ", phone=" + phone + ", btnDelete=" + btnDelete
                + "]";
    }

    
}
