package se.groupRed.maven.jpa.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.groupRed.maven.model.Orderline;

@Repository
public interface OrderlineRepository extends CrudRepository<Orderline, Long> {

	List<Orderline> findById(Long id);
	
}
