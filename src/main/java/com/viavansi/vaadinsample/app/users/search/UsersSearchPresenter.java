package com.viavansi.vaadinsample.app.users.search;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.BeanContainer;
import com.viavansi.vaadinsample.lib.presenter.Presenter;
import com.viavansi.vaadinsample.models.User;
import com.vaadin.data.Item;

public class UsersSearchPresenter extends Presenter<UsersSearchView> {
	
	public BeanContainer<String, User> dataSource;

	public UsersSearchPresenter(UsersSearchView view) {
		super(view);
	}
	
	public void search(String text) {
		clearSearch();
		
		dataSource.addContainerFilter(new UsersFilter(text));
	}
	
	public void clearSearch() {
		dataSource.removeAllContainerFilters();
	}
	
	public void setDataSource(BeanContainer<String, User> source) {
		dataSource = source;
	}
	
	private class UsersFilter implements Filter {
		private static final long serialVersionUID = -2957052129604749520L;
		private String needle;

		public UsersFilter(String needle) {
			this.needle = needle.toLowerCase();
		}

		public boolean passesFilter(Object itemId, Item item) {
			String haystack = ("" + item.getItemProperty("name").getValue() + item.getItemProperty("lastName").getValue() + item.getItemProperty("company").getValue());
			return haystack.toLowerCase().contains(needle);
		}

		public boolean appliesToProperty(Object id) {
			return true;
		}
	}

}
