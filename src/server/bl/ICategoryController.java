package bl;

import bl_backend.Category;

public interface ICategoryController {
	public void insertCategory(Category category);
	public void deleteCategory(int id);
}
