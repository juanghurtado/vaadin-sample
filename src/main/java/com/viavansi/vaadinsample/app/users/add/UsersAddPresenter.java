package com.viavansi.vaadinsample.app.users.add;

import com.vaadin.data.util.PropertysetItem;
import com.viavansi.vaadinsample.app.users.list.UsersListView;
import com.viavansi.vaadinsample.lib.presenter.Presenter;
import com.viavansi.vaadinsample.services.UsersService;

public class UsersAddPresenter extends Presenter<UsersAddView> {

	public UsersAddPresenter(UsersAddView view) {
		super(view);
	}
	
	public void openUsersListView() {
		goToUsersListView();
	}
	
	public void saveUser(PropertysetItem item) {
		UsersAddView view = (UsersAddView) this.getView();
		
		String name = (String) item.getItemProperty(view.NAME_FIELD).getValue();
		String last_name = (String) item.getItemProperty(view.LAST_NAME_FIELD).getValue();
		String company = (String) item.getItemProperty(view.COMPANY_FIELD).getValue();
		
		UsersService.getInstance().addUser(name, last_name, company);
		
		goToUsersListView();
	}
	
	private void goToUsersListView() {
		getNavigator().navigateTo(UsersListView.VIEW_NAME);
	}
}
