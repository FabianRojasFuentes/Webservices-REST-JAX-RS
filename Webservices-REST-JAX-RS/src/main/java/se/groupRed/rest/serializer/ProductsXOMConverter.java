package se.groupRed.rest.serializer;

import java.util.List;

import se.groupRed.maven.model.Product;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;

public class ProductsXOMConverter
{

	public Document productsToXML(List<Product> products)
	{
		Element productsElement = new Element("products");

		for (Product product : products)
		{

			Element productElement = new Element("product");
			productElement.addAttribute(new Attribute("productId", String.valueOf(product.getId())));

			Element productName = new Element("productName");
			productName.appendChild(String.valueOf(product.getProductName()));
			productElement.appendChild(productName);

			Element price = new Element("price");
			price.appendChild(String.valueOf(product.getPrice()));
			productElement.appendChild(price);

			Element brand = new Element("brand");
			brand.appendChild(String.valueOf(product.getBrand()));
			productElement.appendChild(brand);

			Element referenceNumber = new Element("referenceNumber");
			referenceNumber.appendChild(String.valueOf(product.getReferenceNumber()));
			productElement.appendChild(referenceNumber);

			Element description = new Element("description");
			description.appendChild(String.valueOf(product.getDescription()));
			productElement.appendChild(description);

			Element genre = new Element("genre");
			genre.appendChild(String.valueOf(product.getGenre()));
			productElement.appendChild(genre);

			Element state = new Element("state");
			state.appendChild(String.valueOf(product.getState()));
			productElement.appendChild(state);

			productsElement.appendChild(productElement);

		}
		return new Document(productsElement);

	}
}