package SneakerStore.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import SneakerStore.Dto.CartDto;
import SneakerStore.Entity.Bills;

@Service
public interface IBillService {
	public int AddBills(Bills bill);

	public void AddBillDetail(HashMap<Long, CartDto> carts);
}
