package de.dc.spring.fx.ui.jregis.metro.ui.user.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dc.spring.fx.ui.jregis.metro.ui.user.model.User;
import de.dc.spring.fx.ui.jregis.metro.ui.user.model.UserContext;
import de.dc.spring.fx.ui.jregis.metro.ui.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired UserRepository repository;
	
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
		
		User user = new User(username, password, firstname, lastname, email, address, city, state, country, mobile, birthday, 0L, "", createdOn, updatedOn);
		return repository.save(user);
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
}
