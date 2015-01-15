package com.viavansi.vaadinsample.services;

import com.vaadin.data.util.IndexedContainer;

public class UsersService {

	private static UsersService INSTANCE;
	private IndexedContainer ic = new IndexedContainer();
	
	private static final String FNAME = "First Name";
	private static final String LNAME = "Last Name";
	private static final String COMPANY = "Company";
	private static final String[] fieldNames = new String[] { FNAME, LNAME, COMPANY };
	
	private UsersService(){ 
		for (String p : fieldNames) {
			ic.addContainerProperty(p, String.class, "");
		}

		String[] fnames = { "Peter", "Alice", "Joshua", "Mike", "Olivia",
				"Nina", "Alex", "Rita", "Dan", "Umberto", "Henrik", "Rene",
				"Lisa", "Marge" };
		String[] lnames = { "Smith", "Gordon", "Simpson", "Brown", "Clavel",
				"Simons", "Verne", "Scott", "Allison", "Gates", "Rowling",
				"Barks", "Ross", "Schneider", "Tate" };
		String[] companies = { "Apple", "Viavansi", "Carrefour", "Barclays", "Junta de Andalucía",
				"Endesa", "GitHub" };
		for (int i = 0; i < 1000; i++) {
			Object id = ic.addItem();
			ic.getContainerProperty(id, FNAME).setValue(fnames[(int) (fnames.length * Math.random())]);
			ic.getContainerProperty(id, LNAME).setValue(lnames[(int) (lnames.length * Math.random())]);
			ic.getContainerProperty(id, COMPANY).setValue(companies[(int) (companies.length * Math.random())]);
		}
	}
	
	public static UsersService getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new UsersService();
		}
		
		return INSTANCE; 
	}
	
	public IndexedContainer getUsers() {
		return ic;
	}
	
}
