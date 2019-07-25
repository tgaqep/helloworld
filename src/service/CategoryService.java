package service;

import java.util.List;
import java.util.Map;

import pojo.Category;
 
public interface CategoryService {
 
    List<Category> list();
    Integer addList(List<Category> categorys);
    Category get(int id);
    List<Category> getMore(Map<String,Object> map);
    
    void delete(int id);
    Integer update(Category category);
    
    void addTwo();
    
    void deleteAll();
 
}
