package se.groupRed.rest.serializer;

import java.lang.reflect.Type;

import se.groupRed.maven.model.Address;
import se.groupRed.maven.model.User;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public final class UserJSONConverter implements JsonSerializer<User>, JsonDeserializer<User>
{

	@Override
	public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException
	{
		// Create customer object from json
		final JsonObject userAsJson = json.getAsJsonObject();
		final String firstName = userAsJson.get("firstName").getAsString();
		final String lastName = userAsJson.get("lastName").getAsString();
		final String password = userAsJson.get("password").getAsString();
		final String email = userAsJson.get("email").getAsString();
		final String street = userAsJson.get("street").getAsString();
		final String postal = userAsJson.get("postal").getAsString();
		final String co = userAsJson.get("co").getAsString();
		final String city = userAsJson.get("city").getAsString();
		final String country = userAsJson.get("country").getAsString();
		final String phone = userAsJson.get("phone").getAsString();
		final String state = userAsJson.get("state").getAsString();

		return new User(firstName, lastName, password, email, new Address(street, postal, co, city, country, phone),
				state);
	}

	@Override
	public JsonElement serialize(User src, Type typeOfSrc, JsonSerializationContext context)
	{
		// Create json form customer object
		final JsonObject userAsJson = new JsonObject();

		userAsJson.addProperty("id", src.getId());
		userAsJson.addProperty("firstName", src.getFirstName());
		userAsJson.addProperty("lastName", src.getLastName());
		userAsJson.addProperty("password", src.getPassword());
		userAsJson.addProperty("email", src.getEmail());
		userAsJson.addProperty("street", src.getAddress().getStreet());
		userAsJson.addProperty("postal", src.getAddress().getPostal());
		userAsJson.addProperty("co", src.getAddress().getCo());
		userAsJson.addProperty("city", src.getAddress().getCity());
		userAsJson.addProperty("country", src.getAddress().getCountry());
		userAsJson.addProperty("phone", src.getAddress().getPhone());
		userAsJson.addProperty("state", src.getState());

		return userAsJson;
	}

}