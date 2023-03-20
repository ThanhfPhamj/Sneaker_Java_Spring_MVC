package SneakerStore.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import SneakerStore.Dto.ProductDto;
import SneakerStore.Entity.Categorys;
import SneakerStore.Entity.Users;

public interface IHomeService {
	@Autowired
	public List<Categorys> GetDataCategorys();
	public List<ProductDto> GetDataProducts();
	public List<Users> GetDataUsers();
	
}
