package mapper;

import java.util.List;
import java.util.Map;

import pojo.Category;
  
public interface CategoryMapper {
  
    public Integer add(Category category); 
        
    public void delete(int id); 
        
    public Category get(int id); 
    
    public List<Category> getMore(Map<String,Object> map); 
      
    public Integer update(Category category);  
        
    public List<Category> list();
     
    public Integer count(); 
    
    public Integer addList(List<Category> categorys);
     
}