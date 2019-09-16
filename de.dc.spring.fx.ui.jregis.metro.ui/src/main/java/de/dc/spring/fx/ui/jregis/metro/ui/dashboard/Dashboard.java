package de.dc.spring.fx.ui.jregis.metro.ui.dashboard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import de.dc.spring.fx.ui.jregis.metro.ui.document.repository.DocumentRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.model.Activity;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.repository.ActivityRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.repository.TodoRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.user.model.User;
import de.dc.spring.fx.ui.jregis.metro.ui.user.repository.UserRepository;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

@Controller
public class Dashboard extends BaseDashboard {

	@Autowired ActivityRepository activityRepository;
	@Autowired UserRepository userRepository;
	@Autowired TodoRepository todoRepository;
	@Autowired DocumentRepository documentRepository;
	
	private ObservableList<User> userData = FXCollections.observableArrayList();
	private ObservableList<Document> documentData = FXCollections.observableArrayList();
	
	public void initialize() {
		userData.addAll(userRepository.findAll());
		documentData.addAll(documentRepository.findAll());
		
		List<Activity> activities = activityRepository.findAll();
		for (Activity a : activities) {
			Optional<User> optionalUser = userRepository.findById(a.getUserId());
			String userName = optionalUser.isPresent() ? optionalUser.get().getFirstname()+" "+optionalUser.get().getLastname() : "No User";
			a.setAuthor(userName);
			hboxRecentlyActivities.getChildren().add(new RecentlyActivityItem(a));
		}
		
		todoRepository.findAll().forEach(e->paneTodoList.getChildren().add(new CheckBox(e.getName())));
		
		labelUserCounter.textProperty().bind(Bindings.size(userData).asString());
		labelDocumentsCounter.textProperty().bind(Bindings.size(documentData).asString());
	}
}
