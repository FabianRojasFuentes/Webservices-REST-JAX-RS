package se.groupRed.rest.serializer;

import java.util.List;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import se.groupRed.maven.model.Order;
import se.groupRed.maven.model.Orderline;

public class OrdersXOMConverter
{

	public Document ordersToXML(List<Order> orders)
	{
		Element ordersElement = new Element("orders");

		for (Order order : orders)
		{

			// ORDER
			Element orderElement = new Element("order");
			orderElement.addAttribute(new Attribute("orderId", String.valueOf(order.getId())));

			Element orderReferenceNumber = new Element("orderReferenceNumber");
			orderReferenceNumber.appendChild(String.valueOf(order.getReferenceNumber()));
			orderElement.appendChild(orderReferenceNumber);

			Element orderState = new Element("orderState");
			orderState.appendChild(String.valueOf(order.getState()));
			orderElement.appendChild(orderState);

			// USER
			Element userElement = new Element("user");
			userElement.addAttribute(new Attribute("userId", String.valueOf(order.getUser().getId())));

			Element email = new Element("email");
			email.appendChild(String.valueOf(order.getUser().getEmail()));
			userElement.appendChild(email);

			Element firstName = new Element("firstName");
			firstName.appendChild(String.valueOf(order.getUser().getFirstName()));
			userElement.appendChild(firstName);

			Element lastName = new Element("lastName");
			lastName.appendChild(String.valueOf(order.getUser().getLastName()));
			userElement.appendChild(lastName);

			Element password = new Element("password");
			password.appendChild(String.valueOf(order.getUser().getPassword()));
			userElement.appendChild(password);

			Element userState = new Element("userState");
			userState.appendChild(String.valueOf(order.getUser().getState()));
			userElement.appendChild(userState);

			// ADDRESS
			Element addressElement = new Element("address");

			Element street = new Element("street");
			street.appendChild(String.valueOf(order.getUser().getAddress().getStreet()));
			addressElement.appendChild(street);

			Element postal = new Element("postal");
			postal.appendChild(String.valueOf(order.getUser().getAddress().getPostal()));
			addressElement.appendChild(postal);

			Element co = new Element("co");
			co.appendChild(String.valueOf(order.getUser().getAddress().getCo()));
			addressElement.appendChild(co);

			Element city = new Element("city");
			city.appendChild(String.valueOf(order.getUser().getAddress().getCity()));
			addressElement.appendChild(city);

			Element country = new Element("country");
			country.appendChild(String.valueOf(order.getUser().getAddress().getCountry()));
			addressElement.appendChild(country);

			Element phone = new Element("phone");
			phone.appendChild(String.valueOf(order.getUser().getAddress().getPhone()));
			addressElement.appendChild(phone);

			userElement.appendChild(addressElement);

			orderElement.appendChild(userElement);

			// ORDERLINES
			Element orderlines = new Element("orderlines");
			for (Orderline ol : order.getProductsOrdered())
			{
				Element orderline = new Element("orderline");

				Element orderlineId = new Element("orderlineId");
				orderlineId.appendChild(String.valueOf(ol.getId()));
				orderline.appendChild(orderlineId);

				Element quantity = new Element("quantity");
				quantity.appendChild(String.valueOf(ol.getQuantity()));
				orderline.appendChild(quantity);

				// PRODUCT
				Element productElement = new Element("product");
				productElement.addAttribute(new Attribute("productId", String.valueOf(ol.getProduct().getId())));

				Element productName = new Element("productName");
				productName.appendChild(String.valueOf(ol.getProduct().getProductName()));
				productElement.appendChild(productName);

				Element price = new Element("price");
				price.appendChild(String.valueOf(ol.getProduct().getPrice()));
				productElement.appendChild(price);

				Element brand = new Element("brand");
				brand.appendChild(String.valueOf(ol.getProduct().getBrand()));
				productElement.appendChild(brand);

				Element productReferenceNumber = new Element("productReferenceNumber");
				productReferenceNumber.appendChild(String.valueOf(ol.getProduct().getReferenceNumber()));
				productElement.appendChild(productReferenceNumber);

				Element description = new Element("description");
				description.appendChild(String.valueOf(ol.getProduct().getDescription()));
				productElement.appendChild(description);

				Element genre = new Element("genre");
				genre.appendChild(String.valueOf(ol.getProduct().getGenre()));
				productElement.appendChild(genre);

				Element state = new Element("state");
				state.appendChild(String.valueOf(ol.getProduct().getState()));
				productElement.appendChild(state);

				orderline.appendChild(productElement);

				orderlines.appendChild(orderline);

			}

			orderElement.appendChild(orderlines);

			ordersElement.appendChild(orderElement);

		}

		return new Document(ordersElement);

	}

}
