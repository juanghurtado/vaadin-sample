package com.viavansi.vaadinsample.app.users.search;

import com.viavansi.vaadinsample.lib.presenter.Presenter;
import com.viavansi.vaadinsample.services.UsersService;

public class UsersSearchPresenter extends Presenter<UsersSearchView> {

	public UsersSearchPresenter(UsersSearchView view) {
		super(view);
	}
	
	public void search(String text) {
		UsersService.getInstance().filter(text);
	}
	
	public void clearSearch() {
		UsersService.getInstance().clearFilter();
	}

}
