package com.viavansi.vaadinsample.app.users.list;

import com.vaadin.client.StyleConstants;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class UsersListViewImpl extends VerticalLayout implements UsersListView {

	private static final long serialVersionUID = 3997350938236800619L;
	private final UsersListPresenter presenter;
	
	public UsersListViewImpl() {
		presenter = new UsersListPresenter(this);
		
		generateUI();
		
		this.setSizeFull();
		this.setMargin(true);
	}
	
	private void generateUI() {
		Table usersList = getUsersListTable();
		Label title = getTitleLabel();
		
		this.addComponent(title);
		this.addComponent(usersList);
		
		this.setExpandRatio(usersList, 1);
	}

	private Label getTitleLabel() {
		Label title = new Label();
		title.setValue("Users");
		title.addStyleName(ValoTheme.LABEL_H1);
		
		return title;
	}

	private Table getUsersListTable() {
		IndexedContainer users = presenter.getUsers();
		Table usersList = new Table();
		
		usersList.setContainerDataSource(users);
		usersList.setVisibleColumns(new String[] { "First Name", "Last Name", "Company" });
		usersList.setSelectable(true);
		usersList.setSizeFull();
		usersList.setColumnCollapsingAllowed(true);
		
		return usersList;
	}
	
}
