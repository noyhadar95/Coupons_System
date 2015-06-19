package server.bl;

import server.dal.DAL;
import server.dal.IDAL;
import server.bl_backend.Category;

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
}
