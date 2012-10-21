package se.groupRed.rest.service;

import java.util.ArrayList;
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
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.groupRed.maven.jpa.data.ECommerceService;
import se.groupRed.maven.model.Order;
import se.groupRed.maven.model.Orderline;
import se.groupRed.maven.model.User;

@Path("/user/{userId}/order")
@Produces(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class OrderService
{

	ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
	{ "spring-config.xml" });

	@Autowired
	ECommerceService ec = context.getBean(ECommerceService.class);

	@Context
	private UriInfo uriInfo;

	@GET
	@Path("{ref}")
	public Response getOrderByReferenceNumber(@PathParam("userId") final Long userId, @PathParam("ref") final String ref)
	{
		if (ec.checkOrderWithRefAndUserId(ref, userId))
		{
			return Response.ok(ec.getOrder(ref, Long.valueOf(userId))).build();
		} else
		{
			throw new WebApplicationException(Status.NOT_FOUND);
		}
	}

	@GET
	@Path("/all")
	public List<Order> getAllOrders(@PathParam("userId") final Long userId)
	{
		if (ec.checkUserWithId(userId))
		{
			List<Order> orders = ec.getAllOrders(userId);

			return orders;

		} else
		{
			throw new WebApplicationException(Status.NOT_FOUND);
		}
	}

	@POST
	public Response createOrder(final se.groupRed.rest.model.Order order)
	{

		Long userId = order.getUser().getUserId();
		User user = ec.getUserById(userId);
		List<Orderline> realOrderLines = new ArrayList<>();
		for (se.groupRed.rest.model.Orderline ol: order.getProductsOrdered())
		{
			realOrderLines.add(new Orderline(ec.getProductById(ol.getProduct().getProductId()), ol.getQuantity()));
		}
		ec.addOrder(new Order(order.getState(), order.getReferenceNumber(), user, realOrderLines));
		
		return Response.created(uriInfo.getAbsolutePathBuilder().build()).build();

	}

	@PUT
	@Path("{referenceNumber}")
	public Response updateOrder(@PathParam("userId") final Long userId,
			@PathParam("referenceNumber") final String referenceNumber, final String state)
	{
		if (ec.checkOrderWithRefAndUserId(referenceNumber, userId))
		{

			ec.updateOrder(referenceNumber, state, userId);

			return Response.ok().build();

		} else
		{
			throw new WebApplicationException(Status.NO_CONTENT);
		}

	}

	@DELETE
	@Path("{referenceNumber}")
	public Response DeleteOrder(@PathParam("userId") final Long userId,
			@PathParam("referenceNumber") final String referenceNumber)
	{
		if (ec.checkOrderWithRefAndUserId(referenceNumber, userId))
		{
			ec.deleteOrder(referenceNumber, userId);
			return Response.ok().build();
		} else
		{
			throw new WebApplicationException(Status.NOT_FOUND);
		}
	}

}
