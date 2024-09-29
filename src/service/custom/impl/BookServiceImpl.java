package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.BookDao;
import dto.BookDto;
import entity.BookEntity;
import service.custom.BookService;

public class BookServiceImpl implements BookService  {

    private final BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

    @Override
    public String save(BookDto bookDto) throws Exception {
        BookEntity entity = getBookEntity(bookDto);
        return bookDao.create(entity) ? "Success" : "Fail";
    }

    @Override
    public String update(BookDto bookDto) throws Exception {
        BookEntity entity = getBookEntity(bookDto); 
        return bookDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(Integer id) throws Exception {
        return bookDao.delete(id) ? "Success" : "Fail";
    }

    @Override
    public BookDto get(Integer id) throws Exception {
        BookEntity entity = bookDao.get(id);
        if (entity != null) {
            return getBookDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<BookDto> getAll() throws Exception {
        ArrayList<BookEntity> bookEntities = bookDao.getAll(); 
        if (bookEntities != null && !bookEntities.isEmpty()) {
            ArrayList<BookDto> bookDtos = new ArrayList<>();
            for (BookEntity bookEntity : bookEntities) { 
                bookDtos.add(getBookDto(bookEntity)); 
            }
            return bookDtos;
        }
        
        return null;
    }

    private BookEntity getBookEntity(BookDto bookDto) {
        return new BookEntity(bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPublisher(), bookDto.getYear(),bookDto.getCategory_id());
    }

    private BookDto getBookDto(BookEntity entity) {
        return new BookDto(entity.getId(), entity.getTitle(), entity.getAuthor(), entity.getPublisher(), entity.getYear(), entity.getCategory_id());
    }
}
