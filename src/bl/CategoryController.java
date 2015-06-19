package bl;

import dal.DAL;
import dal.IDAL;
import bl_backend.Category;

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
