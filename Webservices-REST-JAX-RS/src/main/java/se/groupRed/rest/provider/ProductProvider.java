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

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import se.groupRed.maven.model.Product;
import se.groupRed.rest.serializer.ProductJSONConverter;
import se.groupRed.rest.serializer.ProductXOMConverter;

@Provider
@Consumes(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ProductProvider implements MessageBodyReader<Product>, MessageBodyWriter<Product>
{
	static
	{
		gson = new GsonBuilder().registerTypeAdapter(Product.class, new ProductJSONConverter()).create();
		productXOMConverter = new ProductXOMConverter();
	}

	private static final Gson gson;
	private static ProductXOMConverter productXOMConverter;

	// MessageBodyWriter
	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return Product.class.isAssignableFrom(type); // If Product class type is
														// assignable from type
														// then we can use this
														// writer
	}

	@Override
	public long getSize(Product t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return -1; // We don't know the size
	}

	@Override
	public void writeTo(Product product, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException
	{
		if (mediaType.equals(MediaType.APPLICATION_XML_TYPE))
		{
			entityStream.write(productXOMConverter.productToXML(product).toXML().getBytes());
		} else if (mediaType.equals(MediaType.APPLICATION_JSON_TYPE))
		{
			// Write (convert) product to output stream (to client)
			entityStream.write(gson.toJson(product).getBytes());
		}
	}

	// MessageBodyReader
	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return Product.class.isAssignableFrom(type); // If Product class type is
														// assignable from type
														// then we can use this
														// reader
	}

	@Override
	public Product readFrom(Class<Product> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException,
			WebApplicationException
	{
		if (mediaType.equals(MediaType.APPLICATION_JSON_TYPE))
		{
			// Convert from input stream (from client) to Product object
			return gson.fromJson(new InputStreamReader(entityStream), Product.class);
		} else if (mediaType.equals(MediaType.APPLICATION_XML_TYPE))
		{
			Builder builder = new Builder();
			Document document;
			try
			{
				document = builder.build(entityStream);
				return productXOMConverter.documentToProduct(document);
			} catch (ValidityException e)
			{
				e.printStackTrace();
			} catch (ParsingException e)
			{
				e.printStackTrace();
			}
		}
		return null;

	}

}
