package SneakerStore.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProductsDto implements RowMapper<ProductDto> {

	@Override
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto products = new ProductDto();
		products.setId(rs.getLong("id"));
		products.setId_category(rs.getInt("id_category"));
		products.setSizes(rs.getString("sizes"));
		products.setName(rs.getString("name"));
		products.setPrice(rs.getDouble("price"));
		products.setDetails(rs.getString("details"));
		products.setCreated_at(rs.getDate("created_at"));
		products.setUpdated_at(rs.getDate("updated_at"));
		products.setQuantity(rs.getInt("quantity"));
		products.setImg(rs.getString("img"));
		return products;
	}

}
