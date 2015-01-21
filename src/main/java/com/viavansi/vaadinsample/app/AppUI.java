package com.viavansi.vaadinsample.app;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.viavansi.vaadinsample.app.users.add.UsersAddView;
import com.viavansi.vaadinsample.app.users.list.UsersListView;

@Theme("vaadinsample")
@Widgetset("com.viavansi.vaadinsample.AppWidgetSet")
@Title("Vaadin Sample")
@SuppressWarnings("serial")
public final class AppUI extends UI {

    @Override
    protected void init(final VaadinRequest request) {
    	Navigator navigator = new Navigator(this, this);
        
        navigator.addView("", UsersListView.class);
        navigator.addView(UsersListView.VIEW_NAME, UsersListView.class);
        navigator.addView(UsersAddView.VIEW_NAME, UsersAddView.class);
    }
    
}
