package SneakerStore.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SneakerStore.Dao.CategorysDao;
import SneakerStore.Dao.ProductsDao;
import SneakerStore.Dao.UserDao;
import SneakerStore.Dto.ProductDto;
import SneakerStore.Entity.Categorys;
import SneakerStore.Entity.Users;

@Service
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private CategorysDao categoryDao;
	@Autowired
	private ProductsDao productsDao;
	@Autowired
	UserDao userDao;

	@Override
	public List<Categorys> GetDataCategorys() {

		return categoryDao.GetDataCategorys();
	}

	@Override
	public List<ProductDto> GetDataProducts() {
		List<ProductDto> lisProducts = productsDao.GetAllProduct();
		return lisProducts;
	}

	@Override
	public List<Users> GetDataUsers() {
		
		return userDao.GetAllUsers();
	}

}
