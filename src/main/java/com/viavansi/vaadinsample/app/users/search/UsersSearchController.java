package com.viavansi.vaadinsample.app.users.search;

import com.vaadin.data.util.BeanContainer;
import com.viavansi.vaadinsample.lib.controller.GenericController;
import com.viavansi.vaadinsample.lib.filters.UsersFilter;
import com.viavansi.vaadinsample.models.User;

public class UsersSearchController extends GenericController<UsersSearchView> {
	
	public BeanContainer<String, User> dataSource;

	public UsersSearchController(UsersSearchView view) {
		super(view);
	}
	
	public UsersSearchController(UsersSearchView view, BeanContainer<String, User> source) {
		super(view);
		
		dataSource = source;
	}
	
	public void search(String text) {
		clearSearch();
		
		if (dataSource != null) {
			dataSource.addContainerFilter(new UsersFilter(text));
		}
	}
	
	public void clearSearch() {
		if (dataSource != null) {
			dataSource.removeAllContainerFilters();
		}
	}

}
