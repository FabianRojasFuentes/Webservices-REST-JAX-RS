package se.groupRed.maven.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
@Embeddable
public class Address
{

	@XmlElement(name = "street")
	@Column(name = "street_address")
	private String street;

	@XmlElement(name = "postal")
	@Column(name = "postal_address")
	private String postal;

	@XmlElement(name = "co")
	@Column(name = "co_address")
	private String co;

	@XmlElement(name = "city")
	@Column(name = "city_address")
	private String city;

	@XmlElement(name = "country")
	@Column(name = "country_address")
	private String country;

	@XmlElement(name = "phone")
	@Column(name = "phone_address")
	private String phone;

	@SuppressWarnings("unused")
	private Address()
	{
	}

	public Address(String street, String postal, String co, String city, String country, String phone)
	{
		this.street = street;
		this.postal = postal;
		this.co = co;
		this.city = city;
		this.country = country;
		this.phone = phone;
	}

	public String getStreet()
	{
		return street;
	}

	public String getPostal()
	{
		return postal;
	}

	public String getCity()
	{
		return city;
	}

	public String getCo()
	{
		return co;
	}

	public String getCountry()
	{
		return country;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public void setCo(String co)
	{
		this.co = co;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public void setPostal(String postal)
	{
		this.postal = postal;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	@Override
	public String toString()
	{
		return "Address [street=" + street + ", postal=" + postal + ", co=" + co + ", city=" + city + ", country="
				+ country + ", phone=" + phone + "]";
	}

}
