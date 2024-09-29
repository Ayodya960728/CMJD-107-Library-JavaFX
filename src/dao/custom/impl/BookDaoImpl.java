package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.BookDao;
import entity.BookEntity;

public class BookDaoImpl implements BookDao {

    @Override
    public boolean create(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO books VALUES(?,?,?,?,?,?)", t.getId(), t.getTitle(), t.getAuthor(), t.getPublisher(), t.getYear(), t.getCategory_id());
    }

    @Override
    public boolean update(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE BOOKS SET NAME = ? WHERE Id = ?", t.getId(), t.getTitle(), t.getAuthor(), t.getPublisher(), t.getYear(),t.getCategory_id());
    }

    @Override
    public boolean delete(Object id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM books WHERE id = ?", id);
    }

    @Override
    public BookEntity get(Object id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM books WHERE id = ?", id);
        if (rst.next()){
            BookEntity entity = new BookEntity(rst.getInt("id"),
                    rst.getString("title"), 
                    rst.getString("author"), 
                    rst.getString("publisher"), 
                    rst.getInt("year"),
                    rst.getInt("category_id"));
            return entity;
        }
        return null;
    }

    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList<BookEntity> bookEntitys = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM books");
        while (rst.next()){
            BookEntity entity = new BookEntity(rst.getInt("id"), 
                    rst.getString("title"),
                    rst.getString("author"), 
                    rst.getString("publisher"),
                    rst.getInt("year"), 
                    rst.getInt("category_id"));
            bookEntitys.add(entity);
        }
        return bookEntitys;
    }
    
}
