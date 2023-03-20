package SneakerStore.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import SneakerStore.Entity.Categorys;
import SneakerStore.Entity.MapperCategorys;

@Repository
public class CategorysDao extends BaseDao {
	public List<Categorys> GetDataCategorys() {

		String sql = "SELECT * FROM categorys";
		List<Categorys> listProducts = _jdbcTemplate.query(sql, new MapperCategorys());
		return listProducts;
	}

	public Categorys getCategorysById(int id) {
		String sql = "select * from categorys where id = " + id + " ";
		return _jdbcTemplate.queryForObject(sql, new MapperCategorys());
	}

	public int create(Categorys categorys) {
		String sql = "insert into categorys( name, description) values('" + categorys.getName() + "', '"
				+ categorys.getDescription() + "' )";
		return _jdbcTemplate.update(sql);
	}

	public int edit(Categorys categorys) {
		String sql = "update categorys set name='" + categorys.getName() + "', description = '" + categorys.getDescription() + "' where id = '" + categorys.getId() + "'";
		return _jdbcTemplate.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from categorys where id='" + id + "'";
		return _jdbcTemplate.update(sql);
	}

	
}
