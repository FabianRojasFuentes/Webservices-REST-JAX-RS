package se.groupRed.rest.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import se.groupRed.maven.model.Order;
import se.groupRed.rest.serializer.OrderJSONConverter;
import se.groupRed.rest.serializer.OrderXOMConverter;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Provider
@Consumes(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class OrderProvider implements MessageBodyReader<se.groupRed.rest.model.Order>, MessageBodyWriter<Order>
{

	private static Gson gsonSerializer;
	private static Gson gsonDeserializer;

	private static OrderXOMConverter orderXomConverter;

	static
	{
		gsonSerializer = new GsonBuilder().registerTypeAdapter(Order.class, new OrderJSONConverter()).create();
		gsonDeserializer = new GsonBuilder().registerTypeAdapter(se.groupRed.rest.model.Order.class, new OrderJSONConverter()).create();
		orderXomConverter = new OrderXOMConverter();
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return Order.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(Order t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return -1;
	}

	@Override
	public void writeTo(Order order, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException,
			WebApplicationException
	{

		if (mediaType.equals(MediaType.APPLICATION_JSON_TYPE))
		{
			entityStream.write(gsonSerializer.toJson(order).getBytes());
		} else if (mediaType.equals(MediaType.APPLICATION_XML_TYPE))
		{
			entityStream.write(orderXomConverter.orderToXML(order).toXML().getBytes());
		}
	}

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return se.groupRed.rest.model.Order.class.isAssignableFrom(type);
	}

	@Override
	public se.groupRed.rest.model.Order readFrom(Class<se.groupRed.rest.model.Order> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException,
			WebApplicationException
	{
		if (mediaType.equals(MediaType.APPLICATION_JSON_TYPE))
		{
			System.out.println("hej fran if");
			
			return gsonDeserializer.fromJson(new InputStreamReader(entityStream), se.groupRed.rest.model.Order.class);
		} else if (mediaType.equals(MediaType.APPLICATION_XML_TYPE))
		{
			System.out.println("hej fran elseif");
			
			Builder builder = new Builder();
			Document document;
			try
			{
				document = builder.build(entityStream);
				return orderXomConverter.documentToOrder(document);
			} catch (ValidityException e)
			{
				e.printStackTrace();
			} catch (ParsingException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("hej fran return null");
		return null;
	}

}
