package se.groupRed.rest.model;

public class Orderline {

	private Long id;


	private Product product;
	private int quantity = 0;
//	private int totalPrice;



	public Orderline(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

//	public void setTotalPrice(int totalPrice)
//	{
//		this.totalPrice = totalPrice;
//	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

//	public int getTotalPrice()
//	{
//		int intprice = Integer.parseInt(product.getPrice());
//		totalPrice = intprice * quantity;
//		return totalPrice;
//	}

}