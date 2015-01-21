package com.viavansi.vaadinsample.lib.presenter;

import com.vaadin.navigator.Navigator;
import com.viavansi.vaadinsample.app.AppUI;
import com.viavansi.vaadinsample.lib.view.View;

public abstract class Presenter <T extends View> {
	
	private T view;

	public Presenter() {
		
	}
	
	public Presenter (T view) {
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

}