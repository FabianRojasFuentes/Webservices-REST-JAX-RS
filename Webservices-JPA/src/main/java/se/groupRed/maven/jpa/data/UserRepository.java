package se.groupRed.maven.jpa.data;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import se.groupRed.maven.model.Order;
import se.groupRed.maven.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
	User findById(Long id);
	
	User findByEmail(String email); 
	
	List<User> findAll();
	
	@Modifying
	@Transactional(readOnly=false)
	@Query("update User u set u.firstName = :firstName, u.lastName = :lastName, u.password = :password WHERE u.email = :email")
	int updateUser(@Param("firstName") String firstname,
				   @Param("lastName") String lastName, 
				   @Param("password") String password, 
				   @Param("email") String email);
	
	@Modifying
	@Transactional(readOnly=false)
	@Query("update User u set u.address.street = :street_address, u.address.postal = :postal_address, u.address.co = :co_address," +
			" u.address.city = :city_address, u.address.country = :country_address, u.address.phone = :phone_address WHERE u.email = :email")
	int updateAddress(@Param("street_address") String street_address,
				      @Param("postal_address") String postal_address, 
				      @Param("co_address") String co_address, 
				      @Param("city_address") String city_address, 
				      @Param("country_address") String country_address,
				      @Param("phone_address") String phone_address,
					  @Param("email") String email);
	
	
	@Modifying
	@Transactional(readOnly=false)
	@Query("update User u set u.state = :state WHERE u.email = :email")
	int deleteUser(@Param("email") String email, @Param("state") String state);
	
}
