package server.bl;

import javax.swing.table.DefaultTableModel;

import server.dal.DAL;
import server.dal.IDAL;
import auxiliary.bl_backend.Category;

public class CategoryController implements ICategoryController {

	private IDAL dal;

	public CategoryController() {
		dal = new DAL();
	}
	
	@Override
	public void insertCategory(Category category) {
		dal.insertCategory(category);
		
	}
	
	@Override
	public void deleteCategory(int id) {
		dal.deleteCategory(id);
		
	}
	@Override
	public DefaultTableModel getAllCategories(){
		return dal.getAllCategories();
	}
}
