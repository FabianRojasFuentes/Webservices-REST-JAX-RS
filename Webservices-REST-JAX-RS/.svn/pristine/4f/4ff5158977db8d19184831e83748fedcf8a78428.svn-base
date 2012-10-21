package se.groupRed.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.groupRed.maven.jpa.data.ECommerceService;
import se.groupRed.maven.model.User;

@Path("/user")
@Produces(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public final class UserService
{
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
	{ "spring-config.xml" });

	@Autowired
	ECommerceService ec = context.getBean(ECommerceService.class);

	@Context
	private UriInfo uriInfo;

	@GET
	@Path("{id}")
	public Response getUserById(@PathParam("id") final String id)
	{
		if (ec.checkUser(id))
		{
			return Response.ok(ec.getUser(id)).build();
		} else
		{
			throw new WebApplicationException(Status.NOT_FOUND);
		}
	}

	@GET
	@Path("/all")
	public List<User> getAllUsers()
	{
		List<User> users = ec.getAllUsers();

		return users;
	}

	@POST
	public Response createUser(final User user)
	{
		if (ec.checkUser(user.getEmail()))
		{
			throw new WebApplicationException(Status.CONFLICT);
		} else
		{

			ec.addUser(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), user.getAddress()
					.getStreet(), user.getAddress().getPostal(), user.getAddress().getCo(),
					user.getAddress().getCity(), user.getAddress().getCountry(), user.getAddress().getPhone());

			return Response.created(uriInfo.getAbsolutePathBuilder().path(user.getEmail()).build()).build();

		}

	}

	@PUT
	@Path("{id}")
	public Response updateUser(@PathParam("id") final String id, final User user)
	{

		if (ec.checkUser(id))
		{
			ec.updateUser(user.getFirstName(), user.getLastName(), user.getPassword(), id, user.getAddress()
					.getStreet(), user.getAddress().getPostal(), user.getAddress().getCo(),
					user.getAddress().getCity(), user.getAddress().getCountry(), user.getAddress().getPhone());

			return Response.ok().build();

		} else
		{

			throw new WebApplicationException(Status.NO_CONTENT);

		}

	}

	@DELETE
	@Path("{email}")
	public Response DeleteUser(@PathParam("email") final String email)
	{

		if (ec.checkUser(email))
		{
			ec.deleteUser(email);
			return Response.ok().build();
		} else
		{
			System.out.println("else:" + email);
			throw new WebApplicationException(Status.NOT_FOUND);
		}
	}

}
