package se.groupRed.rest.serializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.groupRed.maven.jpa.data.ECommerceService;
import se.groupRed.maven.model.Order;
import se.groupRed.maven.model.Orderline;
import se.groupRed.maven.model.Product;
import se.groupRed.maven.model.User;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public final class OrderJSONConverter implements JsonSerializer<Order>, JsonDeserializer<se.groupRed.rest.model.Order>
{

	ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
	{ "spring-config.xml" });

	UserJSONConverter userCon = new UserJSONConverter();
	ProductJSONConverter prodCon = new ProductJSONConverter();

	@Autowired
	ECommerceService ec = context.getBean(ECommerceService.class);

	@Override
	public se.groupRed.rest.model.Order deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException
	{

		final JsonObject orderAsJson = json.getAsJsonObject();
		final String state = orderAsJson.get("state").getAsString();
		final String referenceNumber = orderAsJson.get("referenceNumber").getAsString();
		final long customerId = orderAsJson.getAsJsonObject("user").get("userId").getAsLong();
		se.groupRed.rest.model.User user = new se.groupRed.rest.model.User(customerId);
 
		final JsonArray orderLinesJson = orderAsJson.getAsJsonArray("orderlines");
		List<se.groupRed.rest.model.Orderline> orderLines = new ArrayList<se.groupRed.rest.model.Orderline>();
		for (int i = 0; i < orderLinesJson.size(); i++)
		{
			JsonObject jo = (JsonObject) orderLinesJson.get(i);
			
			long productId = jo.getAsJsonObject("product").get("productId").getAsLong();
			
			se.groupRed.rest.model.Product product = new se.groupRed.rest.model.Product(productId);
			
			int quantity = jo.get("quantity").getAsInt();
			
			orderLines.add(new se.groupRed.rest.model.Orderline(product, quantity));
		}
		
		
		return new se.groupRed.rest.model.Order(state, referenceNumber, user, orderLines);

	}

	@Override
	public JsonElement serialize(Order order, Type typeOfSrc, JsonSerializationContext context)
	{

		final JsonObject orderAsJson = new JsonObject();

		orderAsJson.addProperty("orderId", order.getId());
		orderAsJson.addProperty("state", order.getState());
		orderAsJson.addProperty("referenceNumber", order.getReferenceNumber());

		final JsonObject userAsJson = new JsonObject();

		userAsJson.addProperty("userId", order.getUser().getId());
		orderAsJson.add("user", userAsJson);

		final JsonArray orderlinesAsJson = new JsonArray();
		List<Orderline> orderLines = order.getProductsOrdered();

		for (Orderline ol : orderLines)
		{
			JsonObject orderlineAsJson = new JsonObject();

			JsonObject productAsJson = new JsonObject();
			productAsJson.addProperty("productId", ol.getProduct().getId());
			orderlineAsJson.add("product", productAsJson);
			orderlineAsJson.addProperty("quantity", ol.getQuantity());
			orderlinesAsJson.add(orderlineAsJson);
		}
		orderAsJson.add("orderlines", orderlinesAsJson);

		return orderAsJson;
	}
}