package se.groupRed.maven.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderline_table")
public class Orderline
{

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	@JoinColumn
	private Product product;
	private int quantity = 0;

	public Orderline()
	{
	}

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

}