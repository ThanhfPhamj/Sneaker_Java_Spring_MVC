package SneakerStore.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import SneakerStore.Dto.ProductDto;

@Service
public interface IProductService {
	public ProductDto GetProductByID(long id);
	
	public List<ProductDto> GetProductByIDCategory(int id);
}
