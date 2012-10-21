package se.groupRed.maven.jpa.data;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import se.groupRed.maven.model.Product;
import se.groupRed.maven.model.User;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>
{

	Product findByReferenceNumber(String referenceNumber);
	
	List<Product> findAll();
	
	@Modifying
	@Transactional(readOnly=false)
	@Query("update Product p set p.productName = :productName, p.price = :price, p.brand = :brand, p.description = :description, p.state = :state, p.genre = :genre WHERE p.referenceNumber = :referenceNumber")
	int updateProduct(@Param("productName") String productName,
				   @Param("price") String price, 
				   @Param("brand") String brand,
				   @Param("referenceNumber") String referenceNumber,
				   @Param("description") String description,
				   @Param("genre") String genre,
				   @Param("state") String state);
	
	
	@Modifying
	@Transactional(readOnly=false)
	@Query("update Product p set p.state = :state WHERE p.referenceNumber = :referenceNumber")
	int deleteProduct(@Param("referenceNumber") String referenceNumber,
					@Param("state") String state);

	Product findById(Long id);

}
