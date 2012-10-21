package se.groupRed.rest.serializer;

import java.util.List;

import se.groupRed.maven.model.User;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;

public class UsersXOMConverter
{

	public Document usersToXML(List<User> users)
	{
		Element usersElement = new Element("users");

		for (User user : users)
		{

			Element userElement = new Element("user");
			userElement.addAttribute(new Attribute("userId", String.valueOf(user.getId())));

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

			usersElement.appendChild(userElement);

		}
		return new Document(usersElement);
	}

}
