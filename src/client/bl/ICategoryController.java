package client.bl;

import server.sl.*;
import auxiliary.bl_backend.*;

public interface ICategoryController {
	public void insertCategory(Category category);
	public void deleteCategory(int id);
}
