package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.CategoryDao;
import entity.CategoryEntity;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public boolean create(CategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO categories VALUES(?,?)", t.getId(), t.getName());
    }

    @Override
    public boolean update(CategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE CATEGORIES SET Name = ? WHERE Id = ?", 
                t.getName(), t.getId());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM categories WHERE id = ?", id);
    }

    @Override
    public CategoryEntity get(Integer id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM categories WHERE id = ?", id);
        if(rst.next()){
            CategoryEntity entity = new CategoryEntity(rst.getInt("id"), 
                    rst.getString("name"));
            return entity;
        }
        return null;
    }

    @Override
    public ArrayList<CategoryEntity> getAll() throws Exception {
         ArrayList<CategoryEntity> categoryEntitys = new ArrayList<>();
         ResultSet rst = CrudUtil.executeQuery("SELECT * FROM categories");
         while (rst.next()) {            
            CategoryEntity entity = new CategoryEntity(rst.getInt("id"), 
                    rst.getString("name"));
            categoryEntitys.add(entity);
        }
         return categoryEntitys;
    }
    
}
