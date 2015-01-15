package com.viavansi.vaadinsample.lib.presenter;

import com.viavansi.vaadinsample.lib.view.View;

public class Presenter <T extends View> {
	
	private T view;

	public Presenter() {
		
	}
	
	public Presenter (T view) {
		setView(view);
	}
	
	/**
	 * Get the {@link View} that is associated to this presenter
	 */
	public T getView() {
		return view;
	}
	
	/**
	 * Set the view of this presenter
	 */
	public void setView(T view) {
		this.view = view;
	}

}