package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.controlsfx.control.Notifications;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.PopOver.ArrowLocation;
import org.controlsfx.control.table.TableFilter;

import com.google.common.base.Function;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.control.features.ColumnJRegisIdFeature;
import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import de.dc.fx.ui.jregis.metro.ui.model.Category;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.repository.CategoryRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentNameRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentRepository;
import de.dc.fx.ui.jregis.metro.ui.util.DialogUtil;
import impl.org.controlsfx.autocompletion.AutoCompletionTextFieldBinding;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

public class MainApplication extends BaseMainApplication {

	private Logger log = Logger.getLogger(getClass().getSimpleName());

	private static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/MainApplication.fxml";

	private ObservableList<Document> masterDocumentData = FXCollections.observableArrayList();
	private FilteredList<Document> filteredDocumentData = new FilteredList<>(masterDocumentData, p -> true);

	private ObservableList<Category> masterCategoryData = FXCollections.observableArrayList();

	private ObservableList<String> masterSuggestionData = FXCollections.observableArrayList();
	private FilteredList<String> filteredSuggestionData = new FilteredList<>(masterSuggestionData, p -> true);

	// Pages
	private DocumentFlatDetails documentFlatDetails = new DocumentFlatDetails();
	private PreferencePage preferencePage = new PreferencePage();
	private ProfilePage profilePage = new ProfilePage();
	private Dashboard dashboard = new Dashboard();
	private Inbox inbox = new Inbox();

	private PopOver popOverNotification = new PopOver();
	private PopOver popOverPreferences = new PopOver();
	private PopOver popOverUser = new PopOver();

	@Inject
	UserManagementPage userManagementPage;

	@Inject
	CategoryRepository categoryRepository;

	private TableFilter<Document> tableFilter;

	public MainApplication() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml " + FXML, exception);
		}

		JRegisPlatform.getInstance(IEventBroker.class).register(this);

		initTreeView();
	}

	private Map<Long, Category> registry = new TreeMap<>();

	public Category buildTree(List<Category> models) {
		registry.clear();
		Long firstElement = null;
		for (Category model : models) {
			if (firstElement == null) {
				firstElement = model.getId();
			}
			registry.put(model.getId(), model);
		}
		registry.values().forEach(nav -> {
			Long parentId = nav.getId();
			List<Category> filteredList = models.stream().filter(e->e.getParentId()==parentId).collect(Collectors.toList());
			filteredList.sort((Category o1, Category o2)->o1.getName().compareTo(o2.getName()));
			nav.getChildren().addAll(filteredList);
		});
		
		
		return registry.get(firstElement);
	}

	private void buildTreeItems(TreeItem<Category> parentItem, Category element) {
		TreeItem<Category> newItem = new TreeItem<>(element);
		parentItem.getChildren().add(newItem);
		if (!element.getChildren().isEmpty()) {
			List<Category> children = element.getChildren();
			for (Category category : children) {
				if (category!=element) {
					buildTreeItems(newItem, category);
				}
			}
		}
	}

	private void initTreeView() {
		List<Category> categories = JRegisPlatform.getInstance(CategoryRepository.class).findAll();
		Optional<List<Category>> optionalCategories = Optional.ofNullable(categories);
		optionalCategories.ifPresent(e->{
			Category root = buildTree(categories);
			TreeItem<Category> rootItem = new TreeItem<>(
					new Category("Categories", LocalDateTime.now(), LocalDateTime.now(), -1));
			buildTreeItems(rootItem, root);
			treeView.setRoot(rootItem);
			treeView.setCellFactory(param -> new TreeCell<Category>() {
				@Override
				protected void updateItem(Category item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.getName());
					}
				}
			});
			rootItem.setExpanded(true);
			treeView.setShowRoot(false);
			treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
				if(newValue.getValue().getName().equals("Root")) {
					filteredDocumentData.setPredicate(p->true);
				}else {
					filteredDocumentData.setPredicate(p->p.getCategoryId()==newValue.getValue().getId());
				}
			});
		});
	}

	@Subscribe
	public void openSeeAllAlertsPane(EventContext<String> context) {
		if (context.getEventId().equals("/open/see/all/alerts")) {
			popOverNotification.hide();
			inbox.toFront();
		}
	}

	@Subscribe
	public void closeNotificationViaEventBroker(EventContext<String> context) {
		if (context.getEventId().equals("/close/notification")) {
			if (context.getInput().equals("user")) {
				popOverUser.hide();
				profilePage.toFront();
			} else if (context.getInput().equals("preferences")) {
				popOverUser.hide();
			} else if (context.getInput().equals("notifications")) {
				popOverUser.hide();
			} else if (context.getInput().equals("logout")) {
				popOverUser.hide();
				paneLogin.toFront();
			}
		}
	}

	public void initialize() {
		initData();
		initTableView();
		initCategoryComboBox();
		initControls();
		initBindings();

		popOverNotification.setContentNode(new NotificationAlerts());
		mainStackPane.getChildren().add(preferencePage);
		mainStackPane.getChildren().add(JRegisPlatform.getInstance(UserManagementPage.class));
		mainStackPane.getChildren().add(documentFlatDetails);
		mainStackPane.getChildren().add(profilePage);
		mainStackPane.getChildren().add(dashboard);
		mainStackPane.getChildren().add(inbox);

		dashboard.toFront();
	}

	private void initData() {
		CategoryRepository categoryRepository = JRegisPlatform.getInstance(CategoryRepository.class);
		List<Category> categories = categoryRepository.findAll();
		masterCategoryData.addAll(categories);

		DocumentRepository documentRepository = JRegisPlatform.getInstance(DocumentRepository.class);
		List<Document> documents = documentRepository.findAll();
		masterDocumentData.addAll(documents);

		DocumentNameRepository documentNameRepository = JRegisPlatform.getInstance(DocumentNameRepository.class);
		List<String> documentNames = documentNameRepository.findAll();
		masterSuggestionData.addAll(documentNames);

	}

	private void initControls() {
		new AutoCompletionTextFieldBinding<>(textDocumentName, param -> {
			filteredSuggestionData.setPredicate(p -> p.toLowerCase().contains(param.getUserText().toLowerCase()));
			return filteredSuggestionData;
		});
	}

	private void initCategoryComboBox() {
		comboBoxCategory.setItems(masterCategoryData);
		comboBoxCategory.setConverter(new StringConverter<Category>() {
			@Override
			public String toString(Category c) {
				return c.getName();
			}

			@Override
			public Category fromString(String name) {
				Optional<Category> optionalCategory = masterCategoryData.stream().filter(p -> p.getName().equals(name))
						.findFirst();
				if (optionalCategory.isPresent()) {
					return optionalCategory.get();
				}
				return new Category(name, null, null, -1);
			}
		});
	}

	private void initTableView() {
		columnId.setCellValueFactory(e -> new SimpleObjectProperty<>(e.getValue()));
		columnId.setCellFactory(e -> new ColumnJRegisIdFeature());
		setupCellValueFactory(columnName, e -> new SimpleObjectProperty(e.getName()));
		setupCellValueFactory(columnCreated, e -> new SimpleObjectProperty(e.getCreatedOnAsString()));
		setupCellValueFactory(columnUpdated, e -> new SimpleObjectProperty(e.getUpdatedOnAsString()));
		columnCategory.setCellValueFactory(param -> {
			long id = param.getValue().getCategoryId();
			Optional<Category> category = JRegisPlatform.getInstance(CategoryRepository.class).findById(id);
			if (category.isPresent()) {
				return new SimpleObjectProperty<>(category.get().getName());
			}
			return new SimpleObjectProperty<>("");
		});

		tableViewDocument.setItems(filteredDocumentData);

		tableFilter = TableFilter.forTableView(tableViewDocument).apply();
		tableFilter.setSearchStrategy((input, target) -> {
			try {
				return target.toLowerCase().contains(input.toLowerCase());
			} catch (Exception e) {
				return false;
			}
		});

		textSearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredDocumentData.setPredicate(p -> {
				String searchContent = newValue.toLowerCase();
				boolean isEmpty = newValue == null || newValue.isEmpty();
				boolean isNameEquals = p.getName().toLowerCase().contains(searchContent);
				boolean isIdEquals = String.valueOf(p.getId()).contains(searchContent);
				boolean isCreatedEquals = p.getCreatedOnAsString() != null
						&& p.getCreatedOnAsString().contains(searchContent);
				boolean isUpdatedEquals = p.getUpdatedOnAsString() != null
						&& p.getUpdatedOnAsString().contains(searchContent);
				return isEmpty || isNameEquals || isCreatedEquals || isUpdatedEquals || isIdEquals;
			});
		});
	}

	private void initBindings() {
		buttonAddDocumentNameSuggestion.disableProperty().bind(textDocumentName.textProperty().isEmpty());
		labelEntriesSize.textProperty().bind(Bindings.format("Showing %d of %d entries",
				Bindings.size(filteredDocumentData), Bindings.size(masterDocumentData)));
		buttonCreateDocument.disableProperty().bind(textDocumentName.textProperty().isEmpty());
	}

	@Override
	protected void onButtonLoginAction(ActionEvent event) {
		paneDocumentTableView.toFront();
	}

	@Override
	protected void onLinkCreateNewUserAction(ActionEvent event) {
	}

	@Override
	protected void onLinkForgottenPasswordAction(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onMenuItemDeleteDocumentAction(ActionEvent event) {
		Document selection = tableViewDocument.getSelectionModel().getSelectedItem();
		if (selection != null) {
			String message = "Do you really want to delete \"" + selection.getName() + "\"";
			Optional<ButtonType> dialog = DialogUtil.openQuestion("Delete Selection",
					"Delete selected document with ID: " + selection.getId(), message);
			dialog.ifPresent(e -> {
				if (e.getButtonData().equals(ButtonData.OK_DONE)) {
					JRegisPlatform.getInstance(DocumentRepository.class).delete(selection);
					Notifications.create().darkStyle().title("Delete selection").text(message).show();
					masterDocumentData.remove(selection);
				}
			});
		}
	}

	@Override
	protected void onMenuItemEditDocumentAction(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onMenuItemNewDocumentAction(ActionEvent event) {
		if (!vboxDocumentOverviewContent.getChildren().contains(paneAddNewDocument)) {
			vboxDocumentOverviewContent.getChildren().add(paneAddNewDocument);
			comboBoxCategory.getSelectionModel().selectFirst();
		}
	}

	@Override
	protected void onMenuItemOpenDocumentAction(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	public static <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}

	@Override
	protected void onTableViewDocumentClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			Document selection = tableViewDocument.getSelectionModel().getSelectedItem();
			if (selection != null) {
				Task<Void> task = new Task<Void>() {
					@Override
					protected Void call() throws Exception {
						Platform.runLater(() -> documentFlatDetails.setSelection(selection));
						return null;
					}
				};
				new Thread(task).start();
				documentFlatDetails.toFront();
			}
		}
	}

	@Override
	protected void onButtonCancelAction(ActionEvent event) {
		vboxDocumentOverviewContent.getChildren().remove(paneAddNewDocument);
	}

	@Override
	protected void onButtonCreateAction(ActionEvent event) {
		String name = textDocumentName.getText();
		String description = textDescription.getText();
		LocalDateTime createdOn = LocalDateTime.now();
		String url = textUrl.getText();

		Document document = new Document(name, createdOn, createdOn, -1, description, url);

		Category category = comboBoxCategory.getSelectionModel().getSelectedItem();
		if (category != null) {
			document.setCategoryId(category.getId());
		}

		long newDocumentId = JRegisPlatform.getInstance(DocumentRepository.class).save(document);
		document.setId(newDocumentId);
		masterDocumentData.add(document);
	}

	@Override
	protected void onButtonAddCategoryAction(ActionEvent event) {
		DialogUtil.openInput("New Category", "Category*", "Create new Category", "", e -> {
			LocalDateTime createdOn = LocalDateTime.now();
			Category category = new Category(e, createdOn, createdOn, -1);
			long newId = JRegisPlatform.getInstance(CategoryRepository.class).save(category);
			category.setId(newId);
			masterCategoryData.add(category);

			comboBoxCategory.getSelectionModel().select(category);
		});
	}

	@Override
	protected void onButtonEditCategoryAction(ActionEvent event) {
		Category selection = comboBoxCategory.getSelectionModel().getSelectedItem();
		if (selection != null) {
			DialogUtil.openInput("Edit Category", selection.getName(), "Edit Category", "", e -> {
				selection.setName(e);
				long newId = categoryRepository.save(selection);
				selection.setId(newId);
				masterCategoryData.clear();
				masterCategoryData.addAll(JRegisPlatform.getInstance(CategoryRepository.class).findAll());
				comboBoxCategory.getSelectionModel().select(selection);
			});
		}
	}

	@Override
	protected void onButtonRemoveCategoryAction(ActionEvent event) {
		Category selection = comboBoxCategory.getSelectionModel().getSelectedItem();
		if (selection != null) {
			categoryRepository.delete(selection);
			masterCategoryData.remove(selection);
			comboBoxCategory.getSelectionModel().selectFirst();
		}
	}

	@Override
	protected void onButtonAddDocumentNameSuggestionAction(ActionEvent event) {
		String name = textDocumentName.getText();
		JRegisPlatform.getInstance(DocumentNameRepository.class).save(name);
		masterSuggestionData.add(name);
	}

	@Override
	protected void onMenuItemShowAllAction(ActionEvent event) {
		tableFilter.resetFilter();
		filteredDocumentData.setPredicate(p -> true);
	}

	@Override
	protected void onImageViewNotificationClicked(MouseEvent event) {
		popOverNotification.setArrowLocation(ArrowLocation.TOP_RIGHT);
		popOverNotification.setDetachable(false);
		popOverNotification.setAutoFix(true);
		popOverNotification.show(imageViewNotification);
	}

	@Override
	protected void onImageViewPreferencesClicked(MouseEvent event) {
		popOverPreferences.setArrowLocation(ArrowLocation.TOP_RIGHT);
		popOverPreferences.setDetachable(false);
		popOverPreferences.setAutoFix(true);
		popOverPreferences.show(imageViewPreferences);
	}

	@Override
	protected void onHBoxUserClicked(MouseEvent event) {
		popOverUser.setArrowLocation(ArrowLocation.TOP_CENTER);
		popOverUser.setContentNode(new NotificationUser());
		popOverUser.setDetachable(false);
		popOverUser.setAutoFix(true);
		popOverUser.setArrowSize(0);
		popOverUser.show(panelUser);
	}

	@Override
	protected void onNavigationItemClicked(MouseEvent event) {
		Object source = event.getSource();
		if (source instanceof Label) {
			Label label = (Label) source;
			if (label.getText().equals("Dashboard")) {
				dashboard.toFront();
			} else if (label.getText().equals("Document")) {
				paneDocumentTableView.toFront();
			} else if (label.getText().equals("User Management")) {
				userManagementPage.toFront();
			} else if (label.getText().equals("Information")) {

			} else if (label.getText().equals("License")) {

			} else if (label.getText().equals("Preferences")) {
				preferencePage.toFront();
			}
		}
	}
}
