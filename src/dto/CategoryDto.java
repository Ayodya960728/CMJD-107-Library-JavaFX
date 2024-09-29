package dto;

public class CategoryDto {
   private Integer categoryID;
   private String categoryName;

public Integer getCategoryID() {
    return categoryID;
}
public void setCategoryID(Integer categoryID) {
    this.categoryID = categoryID;
}
public String getCategoryName() {
    return categoryName;
}
public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
}
public CategoryDto(Integer categoryID, String categoryName) {
    this.categoryID = categoryID;
    this.categoryName = categoryName;
}
public CategoryDto() {
}
@Override
public String toString() {
    return "CategoryDto [categoryID=" + categoryID + ", categoryName=" + categoryName + "]";
}



   
}
