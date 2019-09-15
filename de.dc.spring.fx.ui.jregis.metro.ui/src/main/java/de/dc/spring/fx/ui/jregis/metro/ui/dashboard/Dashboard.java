package de.dc.spring.fx.ui.jregis.metro.ui.dashboard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.model.Activity;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.repository.ActivityRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.user.model.User;
import de.dc.spring.fx.ui.jregis.metro.ui.user.repository.UserRepository;

@Controller
public class Dashboard extends BaseDashboard {

	@Autowired ActivityRepository activityRepository;
	@Autowired UserRepository userRepository;
	
	public void initialize() {
		List<Activity> activities = activityRepository.findAll();
		for (Activity a : activities) {
			Optional<User> optionalUser = userRepository.findById(a.getUserId());
			String userName = optionalUser.isPresent() ? optionalUser.get().getFirstname()+" "+optionalUser.get().getLastname() : "No User";
			a.setAuthor(userName);
			hboxRecentlyActivities.getChildren().add(new RecentlyActivityItem(a));
		}
	}
}
