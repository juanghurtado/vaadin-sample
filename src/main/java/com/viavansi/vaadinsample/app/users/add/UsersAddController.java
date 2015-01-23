package com.viavansi.vaadinsample.app.users.add;

import com.viavansi.vaadinsample.app.users.list.UsersListView;
import com.viavansi.vaadinsample.lib.controller.GenericController;
import com.viavansi.vaadinsample.models.User;
import com.viavansi.vaadinsample.services.UsersService;

public class UsersAddController extends GenericController<UsersAddView> {

	public UsersAddController(UsersAddView view) {
		super(view);
	}
	
	public void openUsersListView() {
		goToUsersListView();
	}
	
	public void saveUser(User user) {
		UsersService.getInstance().addUser(user);
		
		goToUsersListView();
	}
	
	private void goToUsersListView() {
		getNavigator().navigateTo(UsersListView.VIEW_NAME);
	}
}
