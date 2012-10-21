package se.groupRed.rest.model;

import java.util.List;

public class Order {

	private String referenceNumber;

	private List<Orderline> productsOrdered;
	
	private User user;

	private String state;
	
	public Order(String state, String referenceNumber, User user, List<Orderline> productsOrdered)
	{
		this.state = state;
		this.referenceNumber = referenceNumber;
		this.user = user;
		this.productsOrdered = productsOrdered;
	}
	
	public void setProductsOrdered(List<Orderline> productsOrdered)
	{
		this.productsOrdered = productsOrdered;
	}

	public void setUser(User userDetails)
	{
		this.user = userDetails;
	}

	public List<Orderline> getProductsOrdered()
	{
		return productsOrdered;
	}

	public User getUser()
	{
		return user;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getReferenceNumber()
	{
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber)
	{
		this.referenceNumber = referenceNumber;
	}

}