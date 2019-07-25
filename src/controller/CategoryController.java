package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;

import pojo.Category;
import service.CategoryService;

@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@ResponseBody
	@RequestMapping("listCategory")
	public List<Category> listCategory() {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(0,6);
		List<Category> cs = categoryService.list();

		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		//return mav;
		return cs;
	}
	
	@ResponseBody
	@RequestMapping("addListCategory")
	public Integer addList(@RequestBody List<Category> categorys) {

		Integer result = categoryService.addList(categorys);

		return result;
	}
	
	@ResponseBody
	@RequestMapping("getOneCategory")
	public Category get(int id) {

		return categoryService.get(id);

	}
	
	@ResponseBody
	@RequestMapping("getMoreCategory")
	public List<Category> getMore(@RequestBody Category category) {

		Map<String,Object> map = new HashMap<>();
		map.put("id", category.getId());
		map.put("name", category.getName());
		return categoryService.getMore(map);

	}
	
	@RequestMapping("deleteCategory")
	public Integer delete(int id) {

		categoryService.delete(id);
		
		return 1;

	}
	
	@ResponseBody
	@RequestMapping("updateCategory")
	public Integer update(@RequestBody Category category) {

		return categoryService.update(category);

	}
	
	@RequestMapping("addTwo")
	public  void addTwo() {
		categoryService.deleteAll();
		categoryService.addTwo();

	}
}
