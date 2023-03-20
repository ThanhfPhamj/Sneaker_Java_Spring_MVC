package SneakerStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SneakerStore.Dao.CategorysDao;
import SneakerStore.Dao.UserDao;
import SneakerStore.Entity.Categorys;
import SneakerStore.Service.Admin.CategorysServiceImpl;


@Controller
public class AdminController extends BaseController{
	@RequestMapping(value = "/admin/index")
	public ModelAndView TrangChuAdmin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/index");
		return mv;
	}
	
	// Chuc nang them, xoa, sua loai san pham
		@Autowired
		CategorysServiceImpl categoryService;

		@Autowired
		CategorysDao categorysDao;

		@RequestMapping(value = "/admin/danhsachloaisanpham")
		public ModelAndView ListCategory() {
			_mvShare.setViewName("admin/categorys/index");
			_mvShare.addObject("categorys", _homeService.GetDataCategorys());
			return _mvShare;
		}

		@RequestMapping(value = "/admin/themloaisanpham", method = RequestMethod.GET)
		public ModelAndView CreateCategory(@ModelAttribute("categorys") Categorys categorys) {
			int count = categoryService.AddCategorys(categorys);
			_mvShare.setViewName("admin/categorys/create");
			_mvShare.addObject("categorys", new Categorys());
			return _mvShare;
		}

		@RequestMapping(value = "/admin/themloaisanpham", method = RequestMethod.POST)
		public ModelAndView CreateAccount(@ModelAttribute("categorys") Categorys categorys) {
			int count = categoryService.AddCategorys(categorys);
			_mvShare.setViewName("redirect:/admin/danhsachloaisanpham");
			return _mvShare;
		}

		@RequestMapping(value = "/admin/sualoaisanpham/{id}", method = RequestMethod.GET)
		public ModelAndView EditCategory(@PathVariable String id, @ModelAttribute("categorys") Categorys categorys) {
			_mvShare.setViewName("admin/categorys/edit");
			categorys = categorysDao.getCategorysById(Integer.parseInt(id));
			_mvShare.addObject("categorys", categorys);
			return _mvShare;
		}

		@RequestMapping(value = "/admin/sualoaisanpham/luuthongtin", method = RequestMethod.POST)
		public ModelAndView SaveEditCategory(@ModelAttribute("categorys") Categorys categorys) {
			int count = categoryService.EditCategorys(categorys);
			if (count > 0) {
				_mvShare.setViewName("redirect:/admin/danhsachloaisanpham	");
			}
			return _mvShare;
		}

		@RequestMapping(value = "/admin/xoaloaisanpham/{id}", method = RequestMethod.GET)
		public ModelAndView deleteCategory(@PathVariable String id, @ModelAttribute("categorys") Categorys categorys) {
			int count = categoryService.DeleteCategorys(Integer.parseInt(id));
			_mvShare.addObject("categorys", new Categorys());
			_mvShare.setViewName("redirect:/admin/danhsachloaisanpham");
			return _mvShare;
		}
		
		//Tai Khoan
		@Autowired
		UserDao userDao;

		@RequestMapping(value = "/admin/danhsachnguoidung")
		public ModelAndView ListUser() {
			_mvShare.setViewName("admin/accounts/listuser");
			_mvShare.addObject("accounts", _homeService.GetDataUsers());
			return _mvShare;
		}

}
