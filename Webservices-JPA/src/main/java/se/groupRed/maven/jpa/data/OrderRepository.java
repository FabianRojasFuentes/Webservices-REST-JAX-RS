package se.groupRed.maven.jpa.data;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import se.groupRed.maven.model.Order;
import se.groupRed.maven.model.Orderline;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>
{

//	@Query("INSERT INTO Order o values o.referenceNumber = :referenceNumber, o.state = :state, o.productsOrdered = :productsOrdered")
//	int addOrder(@Param("referenceNumber") String referenceNumber, @Param("state") String state, @Param("productsOrdered") List<Orderline> productsOrdered);
	
	Order findById(Long id);

	Order findByReferenceNumber(String referenceNumber);
	
	@Query("select order WHERE referenceNumber = :referenceNumber AND user_id = :id")
	Order findByReferenceNumberAndUserId(String referenceNumber, Long id);

	Iterable<Order> findAll();

	@Query("select order WHERE user_id = :id")
	List<Order> findAllByUserId(Long id);

	@Query("select orderline from Order o inner join o.productsOrdered orderline where o.id = :id")
	List<Orderline> getAllOrderlinesById(@Param("id") Long id);

	@Modifying
	@Transactional(readOnly = false)
	@Query("update Order o set o.state = :state WHERE o.referenceNumber = :referenceNumber AND o.user.id = :userId")
	int updateOrder(@Param("state") String state, @Param("referenceNumber") String referenceNumber,
			@Param("userId") Long userId);

	@Modifying
	@Transactional(readOnly = false)
	@Query("update Order o set o.state = :state WHERE o.referenceNumber = :referenceNumber AND o.user.id = :userId")
	int deleteOrder(@Param("referenceNumber") String referenceNumber, @Param("state") String state,
			@Param("userId") Long userId);
	
	
	@Modifying
	@Transactional(readOnly = false)
	@Query("update Order o set o.user.id = :userId WHERE o.id = :orderId")
	int setUserOrderRelation(@Param("orderId") Long orderId, @Param("userId") Long userId);

}
