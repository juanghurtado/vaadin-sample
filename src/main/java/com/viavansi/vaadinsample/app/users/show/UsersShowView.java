package com.viavansi.vaadinsample.app.users.show;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;
import com.viavansi.vaadinsample.lib.view.GenericView;
import com.viavansi.vaadinsample.models.User;

public class UsersShowView extends GenericView {

	private static final long serialVersionUID = -910752791048256671L;
	private final UsersShowController controller;
	
	public UsersShowView(User user) {
		controller = new UsersShowController(this, user);
		
		this.setMargin(true);
		
		this.addComponent(getRow("Name:", user.getName()));
		this.addComponent(getRow("Last name:", user.getName()));
		this.addComponent(getRow("Company:", user.getCompany()));
	}

	private HorizontalLayout getRow(String labelText, String valueText) {
		HorizontalLayout layout = new HorizontalLayout();
		Label label = new Label(labelText);
		Label value = new Label(valueText);
		
		label.setStyleName(ValoTheme.LABEL_BOLD);
		
		layout.setSpacing(true);
		
		layout.addComponent(label);
		layout.addComponent(value);
		
		return layout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
	
	}

}
