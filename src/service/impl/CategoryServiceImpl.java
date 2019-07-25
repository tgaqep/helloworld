package service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapper.CategoryMapper;
import pojo.Category;
import service.CategoryService;
 
@Service
public class CategoryServiceImpl  implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;
     
    public List<Category> list(){
        return categoryMapper.list();
    }

	public Integer addList(List<Category> categorys) {
		// TODO Auto-generated method stub
		return categoryMapper.addList(categorys);
	}

	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.get(id);
	}

	public List<Category> getMore(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return categoryMapper.getMore(map);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryMapper.delete(id);
	}

	public Integer update(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.update(category);
	}
	
	public void deleteAll() {
        List<Category> cs = list();
        for (Category c : cs) {
             
            categoryMapper.delete(c.getId());
        }
    }
     
    @Override
    @Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
    public void addTwo() {
         
        Category c1 = new Category();
        c1.setName("短的名字");
        categoryMapper.add(c1);
         
        Category c2 = new Category();
        c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
        categoryMapper.add(c2);
    };
 
}