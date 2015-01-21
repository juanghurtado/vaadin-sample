package com.viavansi.vaadinsample.app.users.search;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class UsersSearchViewImpl extends HorizontalLayout implements UsersSearchView {

	private static final long serialVersionUID = 3861531882521294988L;
	private final UsersSearchPresenter presenter;

	public UsersSearchViewImpl() {
		presenter = new UsersSearchPresenter(this);
		
		final TextField text = getTextField();
		Button button = getButton();
		
		button.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = -1152008427884812260L;

			public void buttonClick(ClickEvent event) {
				if (!text.getValue().isEmpty()) {
					presenter.search(text.getValue());
				} else {
					presenter.clearSearch();
				}
		    }
		});
		
		this.setSpacing(true);
		
		this.addComponent(text);
		this.addComponent(button);
	}
	

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
	
	private TextField getTextField() {
		final TextField text = new TextField();
		
		text.setInputPrompt("Find users…");
		
		return text;
	}
	
	private Button getButton() {
		Button button = new Button("Search");
		
		button.setClickShortcut(KeyCode.ENTER);
		
		return button;
	}

}
