package SneakerStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import SneakerStore.Service.Admin.HomeServiceImpl;




@Controller
public class BaseController {
	@Autowired
//	Biến global hay biến chung có dấu _ ở trước tên biến
	HomeServiceImpl _homeService;
	public ModelAndView _mvShare = new ModelAndView();
	
	/*
	 * @PostConstruct public ModelAndView Init () { _mvShare.addObject("menus",
	 * _homeService.GetDataMenus()); return _mvShare; }
	 */
	
}
