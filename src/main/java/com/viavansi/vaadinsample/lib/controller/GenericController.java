package com.viavansi.vaadinsample.lib.controller;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Window;
import com.viavansi.vaadinsample.app.AppUI;
import com.viavansi.vaadinsample.lib.view.View;

public abstract class GenericController <T extends View> {
	
	private T view;

	public GenericController() {
		
	}
	
	public GenericController (T view) {
		setView(view);
	}
	
	public T getView() {
		return view;
	}
	
	public void setView(T view) {
		this.view = view;
	}
	
	public Navigator getNavigator() {
		return AppUI.getCurrent().getNavigator();
	}
	
	public void showWindow(Window window) {
		AppUI.getCurrent().addWindow(window);
	}

}