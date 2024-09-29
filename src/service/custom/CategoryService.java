package service.custom;

import java.util.ArrayList;

import dto.CategoryDto;
import service.SuperService;

public interface CategoryService extends SuperService {

    String save(CategoryDto categoryDto) throws Exception;
    String update(CategoryDto categoryDto) throws Exception;
    String delete(Integer id) throws Exception;
    CategoryDto get(Integer id) throws Exception;
    ArrayList<CategoryDto> getAll() throws Exception;
}
