package SneakerStore.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SneakerStore.Dao.ProductsDao;
import SneakerStore.Dto.ProductDto;
@Service
public class CategoryServiceImpl implements ICategoryService{
	/* Xu Ly thuc thi */
	@Autowired
	private ProductsDao productsDao;
	
	public List<ProductDto> GetAllProductsByID(int id) {
		return productsDao.GetAllProductsByID(id);
	}

	/* Lay du lieu phan trang */
	public List<ProductDto> GetDataProductsPaginate(int id,int start, int totalPage) {
		return productsDao.GetDataProductsPaginate(id,start, totalPage);
	}

}
