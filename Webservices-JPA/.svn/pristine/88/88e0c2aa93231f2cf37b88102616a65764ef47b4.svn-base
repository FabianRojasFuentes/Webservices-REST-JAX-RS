package se.groupRed.maven.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "user")
@Table(name = "user_table")
public class User
{
	@Id
	@XmlAttribute(name = "userId")
	@GeneratedValue
	private Long id;

	@XmlElement(name = "firstName")
	private String firstName;

	@XmlElement(name = "lastName")
	private String lastName;

	@XmlElement(name = "password")
	private String password;

	@XmlElement(name = "email")
	private String email;

	@XmlElement(name = "state")
	private String state;

	@Embedded
	@XmlElement(name = "address")
	private Address address;

	public User()
	{
	}

	public User(String firstName, String lastName, String password, String email, Address address)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.state = "ACTIVE";
	}

	public User(String firstName, String lastName, String password, String email, Address address, String state)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.state = state;
	}

	public Long getId()
	{
		return id;
	}

	public Address getAddress()
	{
		return address;
	}

	public String getEmail()
	{
		return email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

}