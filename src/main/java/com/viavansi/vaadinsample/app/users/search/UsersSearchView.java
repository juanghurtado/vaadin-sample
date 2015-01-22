package com.viavansi.vaadinsample.app.users.search;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.viavansi.vaadinsample.lib.view.GenericView;
import com.viavansi.vaadinsample.models.User;

public class UsersSearchView extends GenericView {

	private static final long serialVersionUID = 3861531882521294988L;
	private final UsersSearchPresenter presenter;
	private TextField text;

	public UsersSearchView(BeanContainer<String, User> usersList) {
		presenter = new UsersSearchPresenter(this, usersList);
		
		HorizontalLayout layout = new HorizontalLayout();
		
		text = getTextField();
		Button button = getButton();
		
		layout.setSpacing(true);
		
		layout.addComponent(text);
		layout.addComponent(button);
		
		this.setSizeUndefined();
		this.addComponent(layout);
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
		
		return button;
	}

}
