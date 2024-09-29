package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.CategoryDao;
import dto.CategoryDto;
import entity.CategoryEntity;
import service.custom.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = (CategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CATEGORY);

    @Override
    public String save(CategoryDto categoryDto) throws Exception {
        CategoryEntity entity = getCategoryEntity(categoryDto);
         return categoryDao.create(entity) ? "Success" : "Fail";
    }

    @Override
    public String update(CategoryDto categoryDto) throws Exception {
        CategoryEntity entity = getCategoryEntity(categoryDto);
        return categoryDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(Integer id) throws Exception {
      return categoryDao.delete(id) ? "Success" : "Fail";
    }

    @Override
    public CategoryDto get(Integer id) throws Exception {
        CategoryEntity entity = categoryDao.get(id);
        if(entity != null) {
            return getCategoryDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<CategoryDto> getAll() throws Exception {
       ArrayList<CategoryEntity> categoryEntitys = categoryDao.getAll();
       if(categoryEntitys != null && !categoryEntitys.isEmpty()){
            ArrayList<CategoryDto> categoryDtos = new ArrayList<>();
            
            for (CategoryEntity categoryEntity : categoryEntitys) {
               categoryDtos.add(getCategoryDto(categoryEntity));
           }
            
            return categoryDtos;
       }
       return null;
    }
    
    private CategoryEntity getCategoryEntity(CategoryDto categoryDto){
         return new CategoryEntity(categoryDto.getCategoryID(),
                categoryDto.getCategoryName());
    }
    
    private CategoryDto getCategoryDto(CategoryEntity entity){
        return new CategoryDto(entity.getId(), 
                entity.getName());
    }
}
