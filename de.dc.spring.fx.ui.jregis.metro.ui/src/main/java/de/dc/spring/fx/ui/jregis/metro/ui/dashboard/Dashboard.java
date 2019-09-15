package de.dc.spring.fx.ui.jregis.metro.ui.dashboard;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.model.Activity;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.repository.ActivityRepository;

@Controller
public class Dashboard extends BaseDashboard {

	private Logger log = Logger.getLogger(getClass().getSimpleName());

	@Autowired
	ActivityRepository activityRepository;

	public void initialize() {
		List<Activity> activities = activityRepository.findAll();
		for (Activity a : activities) {
			hboxRecentlyActivities.getChildren().add(new RecentlyActivityItem(a));
		}
	}
}
