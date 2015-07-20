package server.bl;

import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.Category;

public interface ICategoryController {
	public void insertCategory(Category category);
	public void deleteCategory(int id);
	public Category selectCategory(String name);
	DefaultTableModel getAllCategories();
}
