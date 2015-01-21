package com.viavansi.vaadinsample.app.users.add;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.viavansi.vaadinsample.app.AppUI;

public class UsersAddViewImpl extends VerticalLayout implements UsersAddView {
	
	private static final long serialVersionUID = 8997350938236800619L;
	private final UsersAddPresenter presenter;
	public String VIEW_NAME = "users/add";
	public String NAME_FIELD = "name";
	public String LAST_NAME_FIELD = "last_name";
	public String COMPANY_FIELD = "company";
	
	FieldGroup formGroup;
	PropertysetItem formItem;
	
	public UsersAddViewImpl() {
		AppUI.getCurrent().getNavigator().addView(VIEW_NAME, this);
		
		presenter = new UsersAddPresenter(this);
		
		this.setMargin(true);
		
		HorizontalLayout header = getHeader();
		FormLayout form = getForm();
		HorizontalLayout actions = getActions();
		
		this.addComponent(header);
		this.addComponent(form);
		this.addComponent(actions);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	
	private FormLayout getForm() {
		FormLayout layout = new FormLayout();
		
		TextField name = getFirstNameField();
		TextField last_name = getLastNameField();
		TextField company = getCompanyField();
		
		formItem = new PropertysetItem();
		formGroup = new FieldGroup(formItem);
		
		formItem.addItemProperty(NAME_FIELD, new ObjectProperty<String>(""));
		formItem.addItemProperty(LAST_NAME_FIELD, new ObjectProperty<String>(""));
		formItem.addItemProperty(COMPANY_FIELD, new ObjectProperty<String>(""));
		
		layout.addComponent(name);
		layout.addComponent(last_name);
		layout.addComponent(company);
		
		formGroup.bind(name, NAME_FIELD);
		formGroup.bind(last_name, LAST_NAME_FIELD);
		formGroup.bind(company, COMPANY_FIELD);
		
		return layout;
	}

	private TextField getCompanyField() {
		TextField field = new TextField("Company");
		
		field.setSizeFull();
		
		return field;
	}

	private TextField getLastNameField() {
		TextField field = new TextField("Last Name");
		
		field.setSizeFull();
		
		return field;
	}

	private TextField getFirstNameField() {
		TextField field = new TextField("First Name");
		
		field.setSizeFull();
		
		return field;
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
		            formGroup.commit();
		            presenter.saveUser(formItem);
		            Notification.show("User added!");
		            
		        } catch (CommitException e) {
		            e.printStackTrace();
		        }
		    }
		});
		return save;
	}
}
