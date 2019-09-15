package de.dc.spring.fx.ui.jregis.metro.ui.dashboard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.model.Activity;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.repository.ActivityRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.model.Todo;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.repository.TodoRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.user.model.User;
import de.dc.spring.fx.ui.jregis.metro.ui.user.repository.UserRepository;
import javafx.scene.control.CheckBox;

@Controller
public class Dashboard extends BaseDashboard {

	@Autowired ActivityRepository activityRepository;
	@Autowired UserRepository userRepository;
	@Autowired TodoRepository todoRepository;
	
	public void initialize() {
		List<Activity> activities = activityRepository.findAll();
		for (Activity a : activities) {
			Optional<User> optionalUser = userRepository.findById(a.getUserId());
			String userName = optionalUser.isPresent() ? optionalUser.get().getFirstname()+" "+optionalUser.get().getLastname() : "No User";
			a.setAuthor(userName);
			hboxRecentlyActivities.getChildren().add(new RecentlyActivityItem(a));
		}
		
		List<Todo> todoList = todoRepository.findAll();
		
		for (Todo todo : todoList) {
			for (int i = 0; i < 20; i++) {
				paneTodoList.getChildren().add(new CheckBox(todo.getName()));
			}
			paneTodoList.getChildren().add(new CheckBox(todo.getName()));
		}
	}
}
