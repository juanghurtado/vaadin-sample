package com.viavansi.vaadinsample.app.users.list;

import com.vaadin.data.util.IndexedContainer;
import com.viavansi.vaadinsample.lib.presenter.Presenter;
import com.viavansi.vaadinsample.services.UsersService;

public class UsersListPresenter extends Presenter<UsersListView> {

	public UsersListPresenter(UsersListView view) {
		super(view);
	}
	
	public IndexedContainer getUsers() {
		return UsersService.getInstance().getUsers();
	}
	
}
