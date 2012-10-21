package se.groupRed.maven.model;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "order_table")
public class Order
{

	@Id
	@GeneratedValue
	@XmlAttribute(name = "orderId")
	private Long id;

	@XmlElement(name = "referenceNumber")
	private String referenceNumber;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@XmlElement(name = "orderlines")
	private List<Orderline> productsOrdered;

	@ManyToOne()
	@XmlElement(name = "user")
	@JoinColumn
	private User user;

	@XmlElement(name = "state")
	private String state;
	
	public Order()
	{
		this.user = new User();
		referenceNumber = UUID.randomUUID().toString();
	}

	public Order(String state, String referenceNumber, User user, List<Orderline> productsOrdered)
	{
		this.user = user;
		this.referenceNumber = referenceNumber;
		this.productsOrdered = productsOrdered;
		this.state = state;
	}
	
	public Order(String state, String referenceNumber, List<Orderline> productsOrdered)
	{
		this.referenceNumber = referenceNumber;
		this.productsOrdered = productsOrdered;
	}

	public void removeItem(String id)
	{
		Iterator<Orderline> it = productsOrdered.iterator();
		while (it.hasNext())
		{
			Orderline next = it.next();
			if (next.getProduct().getReferenceNumber().equals(id))
			{
				it.remove();
			}
		}
	}

	public void changeQuantityItem(String referenceNumber, String quant)
	{
		int intQuant = Integer.parseInt(quant);
		Iterator<Orderline> it = productsOrdered.iterator();
		while (it.hasNext())
		{
			Orderline line = it.next();
			if (line.getProduct().getReferenceNumber().equals(referenceNumber))
			{
				line.setQuantity(intQuant);
			}
		}
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

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
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
