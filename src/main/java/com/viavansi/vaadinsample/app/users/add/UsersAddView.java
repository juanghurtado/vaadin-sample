package com.viavansi.vaadinsample.app.users.add;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import com.viavansi.vaadinsample.lib.view.GenericView;
import com.viavansi.vaadinsample.models.User;

public class UsersAddView extends GenericView {
	
	private static final long serialVersionUID = 8997350938236800619L;
	private final UsersAddPresenter presenter;
	public static final String VIEW_NAME = "users/add";
	private BeanFieldGroup<User> fieldGroup;
	private User user;
	
	public UsersAddView() {
		presenter = new UsersAddPresenter(this);
		user = new User();
		fieldGroup = new BeanFieldGroup<User>(User.class);
		fieldGroup.setItemDataSource(new BeanItem<User>(user));
		
		HorizontalLayout header = getHeader();
		FormLayout form = getForm();
		HorizontalLayout actions = getActions();
		
		this.setMargin(true);
		
		this.addComponent(header);
		this.addComponent(form);
		this.addComponent(actions);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	
	private FormLayout getForm() {
		FormLayout layout = new FormLayout();
		TextField name = getNameField();
		TextField lastName = getLastNameField();
		TextField company = getCompanyField();
		
		layout.addComponent(name);
		layout.addComponent(lastName);
		layout.addComponent(company);
		
		return layout;
	}

	private TextField getCompanyField() {
		TextField company = fieldGroup.buildAndBind("Company", "company", TextField.class);
		
		company.setNullRepresentation("");
		company.setSizeFull();
		
		return company;
	}

	private TextField getLastNameField() {
		TextField lastName = fieldGroup.buildAndBind("Last Name", "lastName", TextField.class);
		
		lastName.setNullRepresentation("");
		lastName.setSizeFull();
		lastName.setRequired(true);
		
		return lastName;
	}

	private TextField getNameField() {
		TextField name = fieldGroup.buildAndBind("Name", "name", TextField.class);
		
		name.setNullRepresentation("");
		name.setSizeFull();
		name.setRequired(true);
		
		return name;
	}
	
	private HorizontalLayout getHeader() {
		Label title = getTitleLabel();
		HorizontalLayout header = new HorizontalLayout();
		
		header.addComponent(title);
		header.setWidth("100%");
		
		return header;
	}

	private Label getTitleLabel() {
		Label title = new Label();
		
		title.setValue("Add user");
		title.addStyleName(ValoTheme.LABEL_H1);
		
		return title;
	}
	
	private HorizontalLayout getActions() {
		HorizontalLayout layout = new HorizontalLayout();
		Button save = getSaveButton();
		Button cancel = getCancelButton();
		
		layout.setMargin(new MarginInfo(0001));
		layout.setSpacing(true);
		
		layout.addComponent(cancel);
		layout.addComponent(save);
		
		return layout;
	}

	private Button getCancelButton() {
		Button cancel = new Button("Cancel");
		
		cancel.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = -1152008427884812260L;

			public void buttonClick(ClickEvent event) {
				presenter.openUsersListView();
		    }
		});
		return cancel;
	}

	private Button getSaveButton() {
		Button save = new Button("Save");
		
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setIcon(FontAwesome.FLOPPY_O);
		
		save.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = -1252008427884812260L;

			public void buttonClick(ClickEvent event) {
				
				try {
		            fieldGroup.commit();
		            presenter.saveUser(user);
		            Notification.show("User added!");
		        } catch (CommitException e) {
		        	
		        	// UGLY AS FUCK!!!
		            TextField name = (TextField) fieldGroup.getField("name");
		            TextField lastName = (TextField) fieldGroup.getField("lastName");
		            
		            if (!name.isValid()) {
		            	name.setComponentError(new UserError("Name is required"));
		            } else {
		            	name.setComponentError(null);
		            }
		            
		            if (!lastName.isValid()) {
		            	lastName.setComponentError(new UserError("Last name is required"));
		            } else {
		            	lastName.setComponentError(null);
		            }
		            
		        }
		    }
		});
		
		return save;
	}
}
