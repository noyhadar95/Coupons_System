package server.bl;

import auxiliary.bl_backend.Category;

public interface ICategoryController {
	public void insertCategory(Category category);
	public void deleteCategory(int id);
}