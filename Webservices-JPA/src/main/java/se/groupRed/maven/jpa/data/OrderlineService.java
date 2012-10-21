package se.groupRed.maven.jpa.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.groupRed.maven.model.Orderline;

@Service
public class OrderlineService
{

	@Autowired
	private OrderlineRepository orderlineRepository;

	public Orderline saveOrderline(final Orderline orderline)
	{
		return orderlineRepository.save(orderline);
	}

	public List<Orderline> getById(Long id)
	{
		return orderlineRepository.findById(id);
	}

	public List<Orderline> getOrderlinesByOrderId(Long id)
	{

		List<Orderline> list = new ArrayList<Orderline>();

		Iterator<Orderline> all = orderlineRepository.findAll().iterator();

		while (all.hasNext())
		{
			if (all.next().getId().equals(id))
			{
				list.add(all.next());
			}
		}
		return list;

	}

}
