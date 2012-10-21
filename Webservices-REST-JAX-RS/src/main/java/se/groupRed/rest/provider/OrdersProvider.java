package se.groupRed.rest.provider;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import se.groupRed.maven.model.Order;
import se.groupRed.rest.serializer.OrdersXOMConverter;

@Provider
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class OrdersProvider implements MessageBodyWriter<List<Order>>
{

	private static OrdersXOMConverter ordersXomConverter;

	static
	{
		ordersXomConverter = new OrdersXOMConverter();
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		if (type.toString().equals("class java.util.ArrayList"))
		{
			ParameterizedType parameterizedType = (ParameterizedType) genericType;
			return (Order.class.equals(parameterizedType.getActualTypeArguments()[0]));
		} else
			return false;
	}

	@Override
	public long getSize(List<Order> t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return -1;
	}

	@Override
	public void writeTo(List<Order> orders, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException
	{
		if (mediaType.equals(MediaType.APPLICATION_JSON_TYPE))
		{
		} else if (mediaType.equals(MediaType.APPLICATION_XML_TYPE))
		{
			entityStream.write(ordersXomConverter.ordersToXML(orders).toXML().getBytes());
		}

	}

}
