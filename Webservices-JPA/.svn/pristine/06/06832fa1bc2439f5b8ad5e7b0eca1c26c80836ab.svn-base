package se.groupRed.maven.jpa.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.groupRed.maven.model.Order;
import se.groupRed.maven.model.Orderline;

@Service
public class OrderService
{

	@Autowired
	public OrderRepository orderRepository;

	public Order getOrderById(Long id)
	{
		return orderRepository.findById(id);
	}

	public Order getOrderByReferenceNumberAndUserId(String referenceNumber, Long id)
	{
		Order order = orderRepository.findByReferenceNumberAndUserId(referenceNumber, id);

		List<Orderline> lines = orderRepository.getAllOrderlinesById(order.getId());

		order.setProductsOrdered(lines);

		return order;
	}

	public List<Order> getAllOrders(Long id)
	{
		return orderRepository.findAllByUserId(id);
	}

	public Order createOrder(final Order order)
	{
		return orderRepository.save(order);
	}

	public void updateOrder(final String state, final String referenceNumber, final Long userId)
	{
		orderRepository.updateOrder(state, referenceNumber, userId);
	}

	public void deleteOrder(final String referenceNumber, final Long userId)
	{
		String state = "CANCELED";
		orderRepository.deleteOrder(referenceNumber, state, userId);
	}

	public boolean checkOrder(String referenceNumber)
	{
		if (orderRepository.findByReferenceNumber(referenceNumber) != null)
		{
			return true;
		} else
			return false;
	}
	
	public Order getOrderByReferenceNumber(String referenceNumber)
	{
		return orderRepository.findByReferenceNumber(referenceNumber);
	}
	
	public void setetUserOrderRelation(final Long orderId, final Long userId){
		
		orderRepository.setUserOrderRelation(orderId, userId);
	}

	public boolean checkOrderWithRefAndUserId(String ref, Long userId)
	{
		Order order = orderRepository.findByReferenceNumberAndUserId(ref, userId);
		
		if(order != null){
			return true;
		} else {
			return false;
		}
		
	}

}
