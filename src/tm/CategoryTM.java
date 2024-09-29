package tm;

import javafx.scene.control.Button;

public class CategoryTM {
    
    private int categoryID;
    private String name;
    private Button btnDelete;
    
    public CategoryTM() {
    }

    public CategoryTM(int categoryID, String name, Button btnDelete) {
        this.categoryID = categoryID;
        this.name = name;
        this.btnDelete = btnDelete;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "CategoryTM [categoryID=" + categoryID + ", name=" + name + ", btnDelete=" + btnDelete + "]";
    }

    
    
}
