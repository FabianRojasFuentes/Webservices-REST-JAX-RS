package se.groupRed.rest.serializer;

import se.groupRed.maven.model.Address;
import se.groupRed.maven.model.User;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;

public class UserXOMConverter
{

	public Document userToXML(User user)
	{

		// USER
		Element userElement = new Element("user");
		userElement.addAttribute(new Attribute("user-id", String.valueOf(user.getId())));

		Element email = new Element("email");
		email.appendChild(String.valueOf(user.getEmail()));
		userElement.appendChild(email);

		Element firstName = new Element("firstName");
		firstName.appendChild(String.valueOf(user.getFirstName()));
		userElement.appendChild(firstName);

		Element lastName = new Element("lastName");
		lastName.appendChild(String.valueOf(user.getLastName()));
		userElement.appendChild(lastName);

		Element password = new Element("password");
		password.appendChild(String.valueOf(user.getPassword()));
		userElement.appendChild(password);

		Element state = new Element("state");
		state.appendChild(String.valueOf(user.getState()));
		userElement.appendChild(state);

		// ADDRESS
		Element addressElement = new Element("address");

		Element street = new Element("street");
		street.appendChild(String.valueOf(user.getAddress().getStreet()));
		addressElement.appendChild(street);

		Element postal = new Element("postal");
		postal.appendChild(String.valueOf(user.getAddress().getPostal()));
		addressElement.appendChild(postal);

		Element co = new Element("co");
		co.appendChild(String.valueOf(user.getAddress().getCo()));
		addressElement.appendChild(co);

		Element city = new Element("city");
		city.appendChild(String.valueOf(user.getAddress().getCity()));
		addressElement.appendChild(city);

		Element country = new Element("country");
		country.appendChild(String.valueOf(user.getAddress().getCountry()));
		addressElement.appendChild(country);

		Element phone = new Element("phone");
		phone.appendChild(String.valueOf(user.getAddress().getPhone()));
		addressElement.appendChild(phone);

		userElement.appendChild(addressElement);

		return new Document(userElement);

	}

	public User documentToUser(Document document)
	{
		Element root = document.getRootElement();

		String firstName = root.getChildElements("firstName").get(0).getValue();
		String lastName = root.getChildElements("lastName").get(0).getValue();
		String email = root.getChildElements("email").get(0).getValue();
		String password = root.getChildElements("password").get(0).getValue();
		String state = root.getChildElements("state").get(0).getValue();

		String street = root.getChildElements("address").get(0).getChildElements("street").get(0).getValue();
		String postal = root.getChildElements("address").get(0).getChildElements("postal").get(0).getValue();
		String co = root.getChildElements("address").get(0).getChildElements("co").get(0).getValue();
		String city = root.getChildElements("address").get(0).getChildElements("city").get(0).getValue();
		String country = root.getChildElements("address").get(0).getChildElements("country").get(0).getValue();
		String phone = root.getChildElements("address").get(0).getChildElements("phone").get(0).getValue();

		return new User(firstName, lastName, password, email, new Address(street, postal, co, city, country, phone),
				state);

	}
}