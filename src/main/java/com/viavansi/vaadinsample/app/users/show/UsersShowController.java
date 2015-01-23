package com.viavansi.vaadinsample.app.users.show;

import com.viavansi.vaadinsample.lib.controller.GenericController;
import com.viavansi.vaadinsample.models.User;

public class UsersShowController extends GenericController<UsersShowView> {
	
	private User user;

	public UsersShowController(UsersShowView view) {
		super(view);
	}
	
	public UsersShowController(UsersShowView view, User model) {
		super(view);
		
		user = model;
	}

}
