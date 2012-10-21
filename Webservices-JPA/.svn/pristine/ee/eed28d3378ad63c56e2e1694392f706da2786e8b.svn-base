package se.groupRed.maven.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
//@XmlRootElement(name = "product")
@Table(name = "product_table")
public class Product
{
	@Id
	@XmlAttribute(name = "productId")
	@GeneratedValue
	private Long id;

	@XmlElement(name = "productName")
	private String productName;

	@XmlElement(name = "price")
	private String price;

	@XmlElement(name = "brand")
	private String brand;

	@XmlElement(name = "referenceNumber")
	private String referenceNumber;

	@XmlElement(name = "description")
	private String description;

	@XmlElement(name = "genre")
	private String genre;

	@XmlElement(name = "state")
	private String state;

	public Product()
	{
	}

	public Product(String productName, String price, String brand, String referenceNumber, String description,
			String genre, String state)
	{
		this.productName = productName;
		this.price = price;
		this.brand = brand;
		this.referenceNumber = referenceNumber;
		this.description = description;
		this.genre = genre;
		this.state = state;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getReferenceNumber()
	{
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber)
	{
		this.referenceNumber = referenceNumber;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	@Override
	public String toString()
	{
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", brand=" + brand
				+ ", referenceNumber=" + referenceNumber + ", description=" + description + ", state=" + state + "]";
	}

}
