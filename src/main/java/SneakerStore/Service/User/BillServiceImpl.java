package SneakerStore.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SneakerStore.Dao.BillsDao;
import SneakerStore.Dto.CartDto;
import SneakerStore.Entity.BillDetail;
import SneakerStore.Entity.Bills;

@Service
public class BillServiceImpl implements IBillService{
	
	@Autowired
	private BillsDao billsDao;
	@Override
	public int AddBills(Bills bill) {
		
		return billsDao.AddBills(bill);
	}

	@Override
	public void AddBillDetail(HashMap<Long, CartDto> carts) {
		long iBills = billsDao.GetIdLastBills();
		
		for(Map.Entry<Long, CartDto> itemCart : carts.entrySet())
		{
			BillDetail billDetail = new BillDetail();
			billDetail.setId(iBills);
			billDetail.setId_product(itemCart.getValue().getProduct().getId());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDao.AddBillsDetail(billDetail);
		}
	}

}
