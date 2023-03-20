package SneakerStore.Service.Admin;

import org.springframework.stereotype.Service;

import SneakerStore.Entity.Categorys;

@Service
public interface ICategoryService {
	public int AddCategorys(Categorys categorys);
	public int EditCategorys(Categorys categorys);
	public int DeleteCategorys(int id);

}
