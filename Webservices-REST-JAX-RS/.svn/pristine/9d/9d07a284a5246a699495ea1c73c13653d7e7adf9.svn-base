package se.groupRed.rest.serializer;

import se.groupRed.maven.model.Product;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;

public class ProductXOMConverter
{

	public Document productToXML(Product product)
	{
		Element productElement = new Element("product");
		productElement.addAttribute(new Attribute("product-id", String.valueOf(product.getId())));

		Element productName = new Element("product-name");
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

		return new Document(productElement);
	}

	public Product documentToProduct(Document document)
	{
		Element root = document.getRootElement();

		String productName = root.getChildElements("productName").get(0).getValue();
		String price = root.getChildElements("price").get(0).getValue();
		String brand = root.getChildElements("brand").get(0).getValue();
		String referenceNumber = root.getChildElements("referenceNumber").get(0).getValue();
		String description = root.getChildElements("description").get(0).getValue();
		String genre = root.getChildElements("genre").get(0).getValue();
		String state = root.getChildElements("state").get(0).getValue();

		return new Product(productName, price, brand, referenceNumber, description, genre, state);

	}
}