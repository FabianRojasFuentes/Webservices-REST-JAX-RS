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
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.groupRed.maven.jpa.data.ECommerceService;
import se.groupRed.maven.model.Product;

@Path("/product")
@Produces(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(
{ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public final class ProductService
{

	ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
	{ "spring-config.xml" });

	@Autowired
	ECommerceService ec = context.getBean(ECommerceService.class);

	@Context
	private UriInfo uriInfo;

	@GET
	@Path("{id}")
	public Response getProductById(@PathParam("id") final String id)
	{
		if (ec.checkProduct(id))
		{
			return Response.ok(ec.getProduct(id)).build();
		} else
		{
			throw new WebApplicationException(Status.NOT_FOUND);
		}
	}

	@GET
	@Path("/all")
	public List<Product> getAllProducts()
	{
		List<Product> products = ec.getAllProducts();

		return products;
	}

	@POST
	public Response createProduct(final Product product)
	{

		if (ec.checkProduct(product.getReferenceNumber()))
		{
			throw new WebApplicationException(Status.CONFLICT);
		} else
		{

			ec.addProduct(product.getProductName(), product.getPrice(), product.getBrand(),
					product.getReferenceNumber(), product.getDescription(), product.getGenre(), product.getState());

			return Response.created(uriInfo.getAbsolutePathBuilder().path(product.getReferenceNumber()).build())
					.build();

		}
	}

	@PUT
	@Path("{ref}")
	public Response updateProduct(@PathParam("ref") final String ref, final Product product)
	{
		if (ec.checkProduct(ref))
		{

			ec.updateProduct(product.getProductName(), product.getPrice(), product.getBrand(), ref,
					product.getDescription(), product.getGenre(), product.getState());

			return Response.ok().build();

		} else
		{
			throw new WebApplicationException(Status.NO_CONTENT);
		}

	}

	@DELETE
	@Path("{referenceNumber}")
	public Response DeleteProduct(@PathParam("referenceNumber") final String referenceNumber)
	{

		if (ec.checkProduct(referenceNumber))
		{
			ec.deleteProduct(referenceNumber);
			return Response.ok().build();
		} else
		{
			System.out.println("else:" + referenceNumber);
			throw new WebApplicationException(Status.NO_CONTENT);
		}
	}

}