package client.bl;

import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;

public interface ICategoryController {
	public void insertCategory(Category category);
	public void deleteCategory(int id);
	public Category selectCategory(String name);
	DefaultTableModel getAllCategories();
	Category[] getAllCategoriesArray();
}
