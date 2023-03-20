package SneakerStore.Dao;

import org.springframework.stereotype.Repository;

import SneakerStore.Entity.BillDetail;
import SneakerStore.Entity.Bills;

@Repository
public class BillsDao extends BaseDao{
	public int AddBills(Bills bill)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO bills ");
		sql.append("( user, phone, display_name, address, total, quanty, note ) ");
		sql.append("VALUES ");
		sql.append("( '"+bill.getUser()+"', ");
		sql.append(" '"+bill.getPhone()+"', ");
		sql.append(" '"+bill.getDisplay_name()+"', ");
		sql.append(" '"+bill.getAddress()+"', ");
		sql.append(" '"+bill.getTotal()+"', ");
		sql.append(" '"+bill.getQuanty()+"', ");
		sql.append(" '"+bill.getNote()+"' )");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public long GetIdLastBills() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bills;");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {},Long.class);
		return id;
	}
	public int AddBillsDetail(BillDetail billDetail)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO billsdetail ");
		sql.append("( id_product, id_bills, quanty, total ) ");
		sql.append("VALUES ");
		sql.append("( '"+billDetail.getId_product()+"', ");
		sql.append(" '"+ billDetail.getId_bills()+"', ");
		sql.append(" '"+billDetail.getTotal()+"', ");
		sql.append(" '"+billDetail.getQuanty()+"' )");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
}
