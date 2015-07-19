package client.bl;

import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;

public class CategoryController implements ICategoryController {

	private ISL sl;

	public CategoryController() {
		sl = new SL();
	}
	
	@Override
	public void insertCategory(Category category) {
		sl.insertCategory(category);
		
	}
	
	@Override
	public void deleteCategory(int id) {
		sl.deleteCategory(id);
		
	}
	
	@Override
	public DefaultTableModel getAllCategories(){
		return sl.getAllCategories();
	}
	
	@Override
	public Category[] getAllCategoriesArray(){
		DefaultTableModel model = getAllCategories();
		Category[] categories = new Category[model.getRowCount()];
		for (int i = 0; i < model.getRowCount(); i++) {
			int id = (int)model.getValueAt(i, 0);
			String name = (String) model.getValueAt(i, 1);
			Category cat = new Category(id, name);
			categories[i] = cat;
		}
		
		return categories;
	}
}
