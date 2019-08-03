package de.dc.fx.ui.jregis.metro.ui.service;

import java.time.LocalDateTime;
import java.util.List;

import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.control.binding.UserContext;
import de.dc.fx.ui.jregis.metro.ui.model.User;
import de.dc.fx.ui.jregis.metro.ui.repository.UserRepository;

public class UserService {

	@Inject UserRepository repository;
	
	public User create(UserContext context) {
		LocalDateTime createdOn = LocalDateTime.now();
		LocalDateTime updatedOn= LocalDateTime.now();
		String username = context.username.getValue();
		String password = context.password.getValue();
		String firstname = context.firstname.getValue();
		String lastname = context.lastname.getValue();
		String email = context.email.getValue();
		String address = context.address.getValue();
		String city = context.city.getValue();
		String state = context.state.getValue();
		String country = context.country.getValue();
		String mobile = context.mobile.getValue();
		LocalDateTime birthday = context.birthday.getValue();
		
		User user = new User("", createdOn, updatedOn, username, password, firstname, lastname, email, address, city, state, country, mobile, birthday);
		long id = repository.save(user);
		user.setId(id);
		
		return user;
	}

	public List<User> findAll() {
		return repository.findAll();
	}
}
