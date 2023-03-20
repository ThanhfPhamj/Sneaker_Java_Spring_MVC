package SneakerStore.Service.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SneakerStore.Dao.CategorysDao;
import SneakerStore.Dao.ProductsDao;
import SneakerStore.Entity.Categorys;

@Service
public class CategorysServiceImpl implements ICategoryService {

	@Autowired
	CategorysDao categorysDao;

	@Autowired
	private ProductsDao productsDao;

	public int AddCategorys(Categorys categorys) {

		return categorysDao.create(categorys);
	}

	@Override
	public int EditCategorys(Categorys categorys) {

		return categorysDao.edit(categorys);
	}

	@Override
	public int DeleteCategorys(int id) {

		return categorysDao.delete(id);
	}

}
