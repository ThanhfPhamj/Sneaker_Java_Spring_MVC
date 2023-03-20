package SneakerStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SneakerStore.Dto.PaginatesDto;
import SneakerStore.Service.User.CategoryServiceImpl;
import SneakerStore.Service.User.IProductService;
import SneakerStore.Service.User.PaginateServiceImpl;

@Controller
public class ProductsController extends BaseController{
	@RequestMapping(value = "/productspage")
	public ModelAndView TrangChuProduct() {
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.setViewName("user/products/index");
		return _mvShare;
	}
	
	@Autowired
	private CategoryServiceImpl categoryService;
    
	@Autowired
	private PaginateServiceImpl paginateService;
	
	private int totalProductsPage = 9;
	
	@RequestMapping(value = "/sanpham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.setViewName("user/products/category");
		int totalData = categoryService.GetAllProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id),paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	@RequestMapping(value = "/sanpham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id, @PathVariable String currentPage) {
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.setViewName("user/products/category");
		int totalData = categoryService.GetAllProductsByID(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id),paginateInfo.getStart(),totalProductsPage));
		return _mvShare;
	}
	
	@Autowired
	private IProductService _productService;
	
	@RequestMapping(value = { "chi-tiet-san-pham/{id}" })
	public ModelAndView Index(@PathVariable long id) {
		_mvShare.setViewName("user/products/details");
		_mvShare.addObject("product", _productService.GetProductByID(id));
		int idCategory = _productService.GetProductByID(id).getId_category();
		_mvShare.addObject("productByIDCategory", _productService.GetProductByIDCategory(idCategory));
		return _mvShare;
	}
}
