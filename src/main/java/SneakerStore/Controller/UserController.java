package SneakerStore.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SneakerStore.Entity.Users;
import SneakerStore.Service.User.AccountServiceImpl;
@Controller
public class UserController extends BaseController{
	
	@RequestMapping(value = {"/","/index"})
	public ModelAndView TrangChuUser() {
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	
	//Chuc nang dang ky va dang nhap
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();

	@RequestMapping(value = "/dangky", method = RequestMethod.GET)
	public ModelAndView Regiter() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}

	@RequestMapping(value = "/dangky", method = RequestMethod.POST)
	public ModelAndView CreateAccount(@ModelAttribute("user") Users user) {
		int count = accountService.AddAccount(user);
		if (count > 0) {
			_mvShare.addObject("status", "Đăng ký tài khoản thành công");
		} else {
			_mvShare.addObject("status", "Đăng ký tài khoản thất bại");
		}
		_mvShare.setViewName("user/account/login");
		return _mvShare;
	}

	@RequestMapping(value = "/dangnhap", method = RequestMethod.GET)
	public ModelAndView Login() {
		_mvShare.setViewName("user/account/login");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}

	@RequestMapping(value = "/dangnhap", method = RequestMethod.POST)
	public ModelAndView LoginAcc(@ModelAttribute("user") Users user, HttpSession session) {
		user = accountService.CheckAccount(user);
		if (user != null ) {
			_mvShare.setViewName("redirect:/index");
			session.setAttribute("LoginInfo", user);
		} else {
			_mvShare.addObject("statusLogin", "Dang nhap that bai ");
		}

		return _mvShare;
	}
	@RequestMapping(value= "/dangxuat", method = RequestMethod.GET)
	public String Dangxuat(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		session.removeAttribute("Dathang");
		return "redirect:/index";
	}
}
