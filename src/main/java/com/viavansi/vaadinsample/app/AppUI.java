package com.viavansi.vaadinsample.app;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.viavansi.vaadinsample.app.users.list.UsersListViewImpl;

@Theme("vaadinsample")
@Widgetset("com.viavansi.vaadinsample.AppWidgetSet")
@Title("Vaadin Sample")
@SuppressWarnings("serial")
public final class AppUI extends UI {
	
	private UsersListViewImpl usersListView;

    @Override
    protected void init(final VaadinRequest request) {
    	usersListView = new UsersListViewImpl();
		
		setContent(usersListView);
    }
    
}
