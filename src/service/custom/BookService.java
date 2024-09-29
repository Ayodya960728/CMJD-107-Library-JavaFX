package service.custom;

import java.util.ArrayList;

import dto.BookDto;
import service.SuperService;

public interface BookService extends SuperService {

     String save(BookDto bookDto) throws Exception;
     String update(BookDto bookDto) throws Exception;
     String delete(Integer id) throws Exception;
     BookDto get(Integer id) throws Exception;
     ArrayList<BookDto> getAll() throws Exception;
}
