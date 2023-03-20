package SneakerStore.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SneakerStore.Dao.ProductsDao;
import SneakerStore.Dto.ProductDto;
@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductsDao productDao = new ProductsDao();

	public ProductDto GetProductByID(long id) {
		List<ProductDto> listProducts = productDao.GetProductByID(id);
		return listProducts.get(0);
	}

	public List<ProductDto> GetProductByIDCategory(int id) {
		return productDao.GetAllProductsByID(id);
	}

}
