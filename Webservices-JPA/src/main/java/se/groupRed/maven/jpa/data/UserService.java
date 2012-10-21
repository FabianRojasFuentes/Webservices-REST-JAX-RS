package se.groupRed.maven.jpa.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.groupRed.maven.model.Address;
import se.groupRed.maven.model.User;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;

	public User getUser(Long id)
	{
		return userRepository.findOne(id);
	}

	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	public User getUserWithEmail(final String email)
	{
		return userRepository.findByEmail(email);
	}

	public User addUser(String firstName, String lastName, String password, String email, String street, String postal,
			String co, String city, String country, String phone)
	{
		User user = new User(firstName, lastName, password, email,
				new Address(street, postal, co, city, country, phone));
		return userRepository.save(user);
	}

	public void updateUser(final User user)
	{
		userRepository.updateUser(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail());
		userRepository.updateAddress(user.getAddress().getStreet(), user.getAddress().getPostal(), user.getAddress()
				.getCo(), user.getAddress().getCity(), user.getAddress().getCountry(), user.getAddress().getPhone(),
				user.getEmail());
	}

	public void deleteUser(final String email, final String state)
	{
		userRepository.deleteUser(email, state);
	}

	public boolean checkUser(String email)
	{
		if (userRepository.findByEmail(email) != null)
		{
			return true;
		} else
			return false;
	}

	public boolean checkUserWithId(Long id)
	{
		return userRepository.exists(id);
	}

}
