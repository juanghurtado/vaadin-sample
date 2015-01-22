package com.viavansi.vaadinsample.app.users.list;

import java.util.ArrayList;

import com.vaadin.data.util.BeanContainer;
import com.viavansi.vaadinsample.app.users.add.UsersAddView;
import com.viavansi.vaadinsample.lib.presenter.Presenter;
import com.viavansi.vaadinsample.models.User;
import com.viavansi.vaadinsample.services.UsersService;

public class UsersListPresenter extends Presenter<UsersListView> {
	
	public BeanContainer<String, User> container;

	public UsersListPresenter(UsersListView view) {
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
	
	public void openUsersAddView() {
		getNavigator().navigateTo(UsersAddView.VIEW_NAME);
	}
}
