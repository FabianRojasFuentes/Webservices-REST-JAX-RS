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

import se.groupRed.maven.model.Product;
import se.groupRed.rest.serializer.ProductsXOMConverter;

@Provider
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ProductsProvider implements MessageBodyWriter<List<Product>>
{

	private static ProductsXOMConverter productsXomConverter;

	static
	{
		productsXomConverter = new ProductsXOMConverter();
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		if (type.toString().equals("class java.util.ArrayList"))
		{
			ParameterizedType parameterizedType = (ParameterizedType) genericType;
			return (Product.class.equals(parameterizedType.getActualTypeArguments()[0]));
		} else
			return false;
	}

	@Override
	public long getSize(List<Product> t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return -1;
	}

	@Override
	public void writeTo(List<Product> products, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException
	{
		if (mediaType.equals(MediaType.APPLICATION_JSON_TYPE))
		{
		} else if (mediaType.equals(MediaType.APPLICATION_XML_TYPE))
		{
			entityStream.write(productsXomConverter.productsToXML(products).toXML().getBytes());
		}

	}

}
