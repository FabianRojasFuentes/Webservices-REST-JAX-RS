package se.groupRed.rest.serializer;

import java.lang.reflect.Type;

import se.groupRed.maven.model.Product;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public final class ProductJSONConverter implements JsonSerializer<Product>, JsonDeserializer<Product>
{

	@Override
	public Product deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException
	{
		// Create customer object from json
		final JsonObject productAsJson = json.getAsJsonObject();
		final String productName = productAsJson.get("productName").getAsString();
		final String price = productAsJson.get("price").getAsString();
		final String brand = productAsJson.get("brand").getAsString();
		final String referenceNumber = productAsJson.get("referenceNumber").getAsString();
		final String description = productAsJson.get("description").getAsString();
		final String genre = productAsJson.get("genre").getAsString();
		final String state = productAsJson.get("state").getAsString();

		return new Product(productName, price, brand, referenceNumber, description, genre, state);
	}

	@Override
	public JsonElement serialize(Product src, Type typeOfSrc, JsonSerializationContext context)
	{
		// Create json form customer object
		final JsonObject productAsJson = new JsonObject();

		productAsJson.addProperty("id", src.getId());
		productAsJson.addProperty("productName", src.getProductName());
		productAsJson.addProperty("price", src.getPrice());
		productAsJson.addProperty("brand", src.getBrand());
		productAsJson.addProperty("referenceNumber", src.getReferenceNumber());
		productAsJson.addProperty("description", src.getDescription());
		productAsJson.addProperty("genre", src.getGenre());
		productAsJson.addProperty("state", src.getState());

		return productAsJson;
	}

}
