package SneakerStore.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import SneakerStore.Entity.MapperUsers;
import SneakerStore.Entity.Users;

@Repository
public class UserDao extends BaseDao {
	public int AddAccount(Users user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO users ");
		sql.append("( user, password, display_name, address ) ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append(" '" + user.getUser() + "', ");
		sql.append(" '" + user.getPassword() + "', ");
		sql.append(" '" + user.getDisplay_name() + "', ");
		sql.append(" '" + user.getAddress() + "' ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}

	public Users GetUsersByAcc(Users user) {
		String sql = "SELECT * FROM users WHERE user = '" + user.getUser() + "'";

		Users result = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		return result;
	}

	public List<Users> GetAllUsers() {
		String sql = "SELECT * FROM users";

		List<Users> listUsers = _jdbcTemplate.query(sql, new MapperUsers());
		return listUsers;
	}
}
