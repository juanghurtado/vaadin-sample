package com.viavansi.vaadinsample.app.users.list;

import com.vaadin.data.util.IndexedContainer;
import com.viavansi.vaadinsample.app.AppUI;
import com.viavansi.vaadinsample.app.users.add.UsersAddViewImpl;
import com.viavansi.vaadinsample.lib.presenter.Presenter;
import com.viavansi.vaadinsample.services.UsersService;

public class UsersListPresenter extends Presenter<UsersListView> {

	public UsersListPresenter(UsersListView view) {
		super(view);
	}
	
	public IndexedContainer getUsers() {
		return UsersService.getInstance().getUsers();
	}
	
	public void removeUser(Integer id) {
		UsersService.getInstance().removeUser(id);
	}
	
	public void openUsersAddView() {
		UsersAddViewImpl usersAddView = new UsersAddViewImpl();
		AppUI.getCurrent().getNavigator().navigateTo(usersAddView.VIEW_NAME);
	}
}
