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

import se.groupRed.maven.model.User;
import se.groupRed.rest.serializer.UserJSONConverter;
import se.groupRed.rest.serializer.UserXOMConverter;

@Provider
@Consumes(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class UserProvider implements MessageBodyReader<User>, MessageBodyWriter<User>
{

	private static final Gson gson;
	private static UserXOMConverter userXOMConverter;

	static
	{
		gson = new GsonBuilder().registerTypeAdapter(User.class, new UserJSONConverter()).create();
		userXOMConverter = new UserXOMConverter();
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return User.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(User t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return -1; // We don't know the size
	}

	@Override
	public void writeTo(User user, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException,
			WebApplicationException
	{

		if (mediaType.equals(MediaType.APPLICATION_XML_TYPE))
		{
			entityStream.write(userXOMConverter.userToXML(user).toXML().getBytes());
		} else if (mediaType.equals(MediaType.APPLICATION_JSON_TYPE))
		{
			// Write (convert) user to output stream (to client)
			entityStream.write(gson.toJson(user).getBytes());
		}
	}

	// MessageBodyReader
	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType)
	{
		return User.class.isAssignableFrom(type); // If User class type is
													// assignable from type then
													// we can use this reader
	}

	@Override
	public User readFrom(Class<User> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException,
			WebApplicationException
	{

		if (mediaType.equals(MediaType.APPLICATION_JSON_TYPE))
		{
			// Convert from input stream (from client) to User object
			return gson.fromJson(new InputStreamReader(entityStream), User.class);
		} else if (mediaType.equals(MediaType.APPLICATION_XML_TYPE))
		{
			Builder builder = new Builder();
			Document document;
			try
			{
				document = builder.build(entityStream);
				return userXOMConverter.documentToUser(document);
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