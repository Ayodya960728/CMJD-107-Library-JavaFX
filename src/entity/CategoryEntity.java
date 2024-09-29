package entity;

public class CategoryEntity {
    private Integer id;
    private String name;
    
    public CategoryEntity() {
    }

    public CategoryEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryEntity [id=" + id + ", name=" + name + "]";
    }

    
}
