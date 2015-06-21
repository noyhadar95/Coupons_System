package client.bl;

import server.sl.*;
import auxiliary.bl_backend.*;

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
