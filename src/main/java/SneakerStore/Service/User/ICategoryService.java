package SneakerStore.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import SneakerStore.Dto.ProductDto;

@Service
public interface ICategoryService {
	public List<ProductDto> GetAllProductsByID(int id);

	public List<ProductDto> GetDataProductsPaginate(int id,int start, int totalPage);

}
