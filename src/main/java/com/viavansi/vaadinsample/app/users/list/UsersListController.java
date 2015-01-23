package com.viavansi.vaadinsample.app.users.list;

import java.util.ArrayList;

import com.vaadin.data.util.BeanContainer;
import com.viavansi.vaadinsample.app.users.add.UsersAddView;
import com.viavansi.vaadinsample.lib.controller.GenericController;
import com.viavansi.vaadinsample.models.User;
import com.viavansi.vaadinsample.services.UsersService;

public class UsersListController extends GenericController<UsersListView> {
	
	public BeanContainer<String, User> container;

	public UsersListController(UsersListView view) {
		super(view);
		
		ArrayList<User> users = new ArrayList<User>(UsersService.getInstance().getUsers());
		container = new BeanContainer<String, User>(User.class);
		container.setBeanIdProperty("id");
		container.addAll(users);
	}
	
	public BeanContainer<String, User> getUsers() {
		return container;
	}
	
	public void removeUser(Integer id) {
		User user = container.getItem(id).getBean();
		
		container.removeItem(id);
		UsersService.getInstance().removeUser(user);
	}
	
	public User getUser(Integer id) {
		return UsersService.getInstance().getUser(id);
	}
	
	public void openUsersAddView() {
		getNavigator().navigateTo(UsersAddView.VIEW_NAME);
	}
}
