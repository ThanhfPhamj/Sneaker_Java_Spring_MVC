package SneakerStore.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import SneakerStore.Dto.MapperProductsDto;
import SneakerStore.Dto.ProductDto;

@Repository
public class ProductsDao extends BaseDao {

	public List<ProductDto> GetAllProduct() {
		String sql = "SELECT * FROM products p INNER JOIN categorys c WHERE c.id = p.id_category ORDER BY c.id DESC";
		List<ProductDto> listProducts = _jdbcTemplate.query(sql, new MapperProductsDto());
		return listProducts;

	}

	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("* FROM products ");
		return sql;
	}
	
	public List<ProductDto> GetAllProductsByID(int id) {
		String sql = SqlProductsByID(id).toString();
		List<ProductDto> listProducts = _jdbcTemplate.query(sql, new MapperProductsDto());
		return listProducts;
	}
	
	
	private StringBuffer SqlProductsByID(int id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE ");
		sql.append("id_category = " + id + " ");
		return sql;
	}
	
	private String SqlProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sql = SqlProductsByID(id);
		sql.append("LIMIT " + start + ", "+ totalPage);
		return sql.toString();
	}
	
	public List<ProductDto> GetDataProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sqlGetDataByID = SqlProductsByID(id);
		List<ProductDto> listProductsByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new MapperProductsDto());
		List<ProductDto> listProducts = new ArrayList<ProductDto>();
		if(listProductsByID.size() > 0) {
			String sql = SqlProductsPaginate(id, start, totalPage);
			listProducts = _jdbcTemplate.query(sql, new MapperProductsDto());
		}
		return listProducts;
	}
	
	//Chi tiet san pham
	private String SqlProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE ");
		sql.append("id = " + id + " ");
		sql.append("LIMIT 1 ");
		return sql.toString();
	}
	
	public List<ProductDto> GetProductByID(long id) {
		String sql = SqlProductByID(id);
		List<ProductDto> listProduct = _jdbcTemplate.query(sql, new MapperProductsDto());
		return listProduct;
	}
	//Gio hang
	public ProductDto FindProductByID(long id) {
		String sql = SqlProductByID(id);
		ProductDto product = _jdbcTemplate.queryForObject(sql, new MapperProductsDto());
		return product;
	}
	


}
