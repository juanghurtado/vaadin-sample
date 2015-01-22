package com.viavansi.vaadinsample.services;

import java.util.ArrayList;
import java.util.List;

import com.viavansi.vaadinsample.models.User;

public class UsersService {

	private static UsersService INSTANCE;
	private List<User> users = new ArrayList<User>();
	
	private UsersService(){
		String[] fnames = { "Peter", "Alice", "Joshua", "Mike", "Olivia",
				"Nina", "Alex", "Rita", "Dan", "Umberto", "Henrik", "Rene",
				"Lisa", "Marge" };
		String[] lnames = { "Smith", "Gordon", "Simpson", "Brown", "Clavel",
				"Simons", "Verne", "Scott", "Allison", "Gates", "Rowling",
				"Barks", "Ross", "Schneider", "Tate" };
		String[] companies = { "Apple", "Viavansi", "Carrefour", "Barclays", "Junta de Andalucía",
				"Endesa", "GitHub" };
		
		for (int i = 0; i < 5; i++) {
			User user = new User();
			
			user.setId(i);
			user.setName(fnames[(int) (fnames.length * Math.random())]);
			user.setLastName(lnames[(int) (lnames.length * Math.random())]);
			user.setCompany(companies[(int) (companies.length * Math.random())]);
			
			users.add(user);
		}
	}
	
	public static UsersService getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new UsersService();
		}
		
		return INSTANCE; 
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void removeUser(User user) {
		users.remove(user);
		
	}
	
	public void addUser(User user) {
		user.setId(users.size() + 1);
		users.add(user);
	}
	
}
