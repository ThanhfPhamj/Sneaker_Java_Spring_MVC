	package SneakerStore.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import SneakerStore.Dto.CartDto;
import SneakerStore.Entity.Bills;
import SneakerStore.Entity.Users;
import SneakerStore.Service.User.BillServiceImpl;
import SneakerStore.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	
	@RequestMapping(value = "gio-hang")
	public ModelAndView Index() {
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/cart/cart");
		return _mvShare;
	}
	
	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
		/* return "redirect:/chi-tiet-san-pham/"+id; */
	}
	@RequestMapping(value = "EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request ,HttpSession session, @PathVariable long id, @PathVariable int quanty) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	
	@RequestMapping(value = "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	//Checkout
	
	@Autowired
	BillServiceImpl billService;
	
	@RequestMapping(value= "/checkout", method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request, HttpSession session) {
		
		_mvShare.setViewName("user/bill/checkout");
		Bills bills = new Bills();
		Users loginInfo = (Users)session.getAttribute("LoginInfo"); 
		if(loginInfo!= null) {
			bills.setUser(loginInfo.getUser());
			bills.setAddress(loginInfo.getAddress());
			bills.setDisplay_name(loginInfo.getDisplay_name());	
		}
		_mvShare.addObject("bills",bills);
		return _mvShare;
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bills") Bills bill) {
			int tongsoluong = Integer.parseInt(session.getAttribute("TotalQuantyCart").toString());
			double tongtien = Double.parseDouble(session.getAttribute("TotalPriceCart").toString());
			bill.setQuanty(tongsoluong);
		  bill.setTotal(tongtien);
		 
		if (billService.AddBills(bill) > 0) {
			HashMap<Long, CartDto> carts = (HashMap<Long, CartDto>) session.getAttribute("Cart");
			 billService.AddBillDetail(carts);
		}
		session.removeAttribute("Cart");
		return "redirect:gio-hang";
	}
	 
}
