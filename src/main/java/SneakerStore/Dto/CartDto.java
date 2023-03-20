package SneakerStore.Dto;

public class CartDto {
	private int quanty;
	private double totalPrice;
	private ProductDto product;
	public int getQuanty() {
		return quanty;
	}
	
	public CartDto() {
		
	}

	public CartDto(int quanty, double totalPrice, ProductDto product) {
		super();
		this.quanty = quanty;
		this.totalPrice = totalPrice;
		this.product = product;
	}
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	
}
