package client.bl;

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
}
